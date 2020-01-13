package com.gaja.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaja.app.entity.Project;
import com.gaja.app.entity.Status;
import com.gaja.app.entity.Task;
import com.gaja.app.entity.Type;
import com.gaja.app.repo.ProjectRepo;
import com.gaja.app.repo.TaskRepo;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import io.leangen.graphql.spqr.spring.util.ConcurrentMultiMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@GraphQLApi
@Service
public class TaskService {

	@Autowired
	private TaskRepo taskRepo;

	@Autowired
	private ProjectRepo projectRepo;
	
	private final ConcurrentMultiMap<String, FluxSink<Task>> subscribers = new ConcurrentMultiMap<>();

	@GraphQLMutation
	public Task createTask(String projectCode, String description,
			@GraphQLArgument(name = "status", defaultValue = "\"ASSIGNED\"") Status status, Type type) {
		
		Task task = new Task(projectCode, description, status, type);
		task = taskRepo.save(task);
		Project project = projectRepo.findByCode(projectCode);
		project.addTask(task);
		projectRepo.save(project); 

		return task;
	}
	
	@GraphQLMutation
    public Task updateTask(@GraphQLNonNull String code, String description, @GraphQLNonNull Status status) {
        Task task = taskRepo.findByCode(code);
        if (description != null) {
            task.setDescription(description);
        }
        task.setStatus(status);
        //Notify all the subscribers following this task
        subscribers.get(code).forEach(subscriber -> subscriber.next(task));
        return task;
    }
	
	@GraphQLQuery
    public List<Task> tasks(String projectCode, Status... statuses) {
		List<Task> taskList = projectRepo.findByCode(projectCode).getTasks().stream()
        .filter(task -> statuses == null || Arrays.stream(statuses).anyMatch(status -> task.getStatus() == status))
        .collect(Collectors.toList());
        return taskList;
    }

    @GraphQLQuery
    public Task task(String code) {
        return taskRepo.findByCode(code);
    }

    @GraphQLSubscription
    public Publisher<Task> taskStatusChanged(String code) {
        return Flux.create(subscriber -> subscribers.add(code, subscriber.onDispose(() -> subscribers.remove(code, subscriber))), FluxSink.OverflowStrategy.LATEST);
    }
}
