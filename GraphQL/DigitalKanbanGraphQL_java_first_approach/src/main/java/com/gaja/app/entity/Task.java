package com.gaja.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table
public class Task {

	@Id
	@GeneratedValue
	private int id;
	private String code;
    private String description;
    private Type type;
    private Status status;

    
    
    public Task() {
	}

	@JsonCreator
    public Task(String code, String description, Status status, Type type) {
        this.code = code;
        this.description = description;
        this.status = status;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(Type type) {
		this.type = type;
	}
    
	
    
}