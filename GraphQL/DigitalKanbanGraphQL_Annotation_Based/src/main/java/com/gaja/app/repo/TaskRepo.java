package com.gaja.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaja.app.entity.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer>{

    public Task findByCode(String code);
    
}