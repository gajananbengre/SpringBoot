package com.gaja.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaja.app.entity.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{

	public Project findByCode(String code);
}