package com.atoz.app.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.atoz.app.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos=null;
	private static int count=3;
	
	static {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Date today = new Date();
		Date todayWithZeroTime=null;

		try {
			 todayWithZeroTime = formatter.parse(formatter.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todos=new ArrayList<Todo>(Arrays.asList(new Todo(1, "madhav", "Spring MVC", new Timestamp(new Date().getTime()), false), 
				new Todo(2, "teja", "Oracle ERP apps", new Timestamp(new Date().getTime()), false),
				new Todo(3, "teja", "Cloud platform", new Timestamp(new Date().getTime()), false)));
	}
	
	public List<Todo> retrieveTodos() throws ParseException{
		
		
//		    for (Todo todo2 : todos) {
//		    	  Date sDate1 = todo2.getTargetDate();
//				    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);  
//				    todo2.setTargetDate(date1);
//				    todos.add(todo2);
//			}
		    
		    
		List<Todo> sortedLIst = todos.stream()
		.sorted(Comparator.comparing(Todo::getUser)).collect(Collectors.toList());
		return sortedLIst;
	}
	public Todo retrieveByIdTodos(int id){
		Todo todo1 = todos.stream()
			.filter(todo->todo.getId()==id).findAny().get();
		return todo1;
	}
	
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> todoList = todos.stream()
		.filter(todo->todo.getUser().equalsIgnoreCase(user))
		.collect(Collectors.toList());
		return todoList;
	}
	
	public void addTodo(Todo todo) throws ParseException {
		
		 String sDate1=String.valueOf(todo.getSTargetDate());
		    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
		
        todo.setTargetDate(date1);
		todo.setId(++count);
		todos.add(todo);
	}
	
	public void deleteTodo(int id){
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = (Todo) iterator.next();
			if(todo.getId()==id) {
				iterator.remove();
			}
			
		}
	}
	
	public void updateTodo(int id, Todo newtodo) throws ParseException{
		
		 String sDate1=String.valueOf(newtodo.getSTargetDate());
		    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
		
		    newtodo.setTargetDate(date1);
		newtodo.setId(id);
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = (Todo) iterator.next();
			if(todo.getId()==newtodo.getId()) {
				todo.setUser(newtodo.getUser());
				todo.setDesc(newtodo.getDesc());
				todo.setTargetDate(newtodo.getTargetDate());
			}
			
		}
	}

	
	
}
