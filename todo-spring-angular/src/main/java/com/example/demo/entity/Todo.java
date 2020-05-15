package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="Todo")
@Entity
public class Todo {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String task;
	private String description;
	
	public Todo()
	{
		
	}
	
	public Todo(String task, String description) {
		super();
		this.task = task;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", description=" + description + "]";
	}
	
	
}
