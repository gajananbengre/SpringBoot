package com.gaja.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaja.app.entity.Project;
import com.gaja.app.entity.Task;
import com.gaja.app.repo.ProjectRepo;
import com.gaja.app.repo.TaskRepo;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	@GraphQLQuery
    public Project project(String code) {
        return projectRepo.findByCode(code);
    }

    @GraphQLMutation
    public Project createProject(String code, String name) {
        return projectRepo.save(new Project(code, name));
    }
	
//    @GraphQLQuery
//    public Project project(@GraphQLContext Task task) {
//        return project(taskRepo.findByCode(task.getCode()));
//    }
	
}
