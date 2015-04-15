package com.web.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.mongodb.Todo;
import com.web.repositories.TodoRepository;

/**
 * Standard Restful Controller
 * @author arvin
 */
@RestController
public class TodoController {
	
	@Autowired
	TodoRepository todoRepository;

	
	@RequestMapping(value ="todo", method = RequestMethod.GET)
	public List<Todo> findAll(String name) {
		if(name == null || "".equals(name)){
			return todoRepository.findAll(); 
		}
		return todoRepository.findByTitle(name);
	}
	
	@RequestMapping(value ="todo/{page}/{size}", method = RequestMethod.GET)
	public Page<Todo> findPage(@PathVariable int page,@PathVariable int size) {
		Pageable pageable=new PageRequest(page,size,Direction.ASC,"order");
		return todoRepository.findAll(pageable);
	}
	
	@RequestMapping(value ="todo/{id}", method = RequestMethod.GET)
	public Todo findOne(@PathVariable String id) {
		return todoRepository.findOne(id); 
	}
	
    @RequestMapping(value ="todo", method = RequestMethod.POST)
    public Todo save(HttpServletRequest request,HttpServletResponse response,@RequestBody Todo todo) {
        return todoRepository.save(todo); 
    }
    
    @RequestMapping(value ="todo/{id}", method = RequestMethod.PUT)
    public Todo updata(@PathVariable String id,HttpServletRequest request,HttpServletResponse response,@RequestBody Todo todo) {
        return todoRepository.save(todo); 
    }
    
    @RequestMapping(value ="todo/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) {
        todoRepository.delete(id);
    }
    
}
