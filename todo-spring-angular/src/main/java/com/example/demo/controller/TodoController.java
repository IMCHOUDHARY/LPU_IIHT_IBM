package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TodoDao;
import com.example.demo.entity.Todo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TodoController {

	private TodoDao todoDao;

	@Autowired
	public TodoController(TodoDao todoDao) {
		super();
		this.todoDao = todoDao;
	}
	
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos()
	{
		return todoDao.findAll();
	}
	
	
	@PostMapping("/todos")
    public Todo createEmployee(@Valid @RequestBody Todo todo) {
        return todoDao.save(todo);
    }
	
	@GetMapping("/todos/{value}")
	public List<Todo> getTodosByName()
	{
		return todoDao.findAll();
	}
	
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable(value = "id") int id)
	{
        Todo todo = todoDao.findById(id).get();
        todoDao.delete(todo);
    }
	
	
	@GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable(value = "id") int id)
    {
        Todo todo = todoDao.findById(id).get();
        return ResponseEntity.ok().body(todo);
    }
	
	
	@PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") int id, @Valid @RequestBody Todo todo) 
	{
        Todo todo_obj = todoDao.findById(id).get();

        todo_obj.setTask(todo.getTask());
        todo_obj.setDescription(todo.getDescription());
        final Todo updatedTodo = todoDao.save(todo_obj);
        return ResponseEntity.ok(updatedTodo);
    }
}
