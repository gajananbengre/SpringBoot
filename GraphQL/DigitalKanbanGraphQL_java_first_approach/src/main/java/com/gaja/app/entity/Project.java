package com.gaja.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table
public class Project {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "code", unique = true)
	private String code;
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Task> tasks;

	

	public Project() {
	}

	@JsonCreator
	public Project(String code, String name) {
		this.code = code;
		this.name = name;
		this.tasks = new ArrayList<>(); 
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
