package com.atoz.app.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atoz.app.model.Todo;
import com.atoz.app.service.LoginService;
import com.atoz.app.service.TodoService;

@Controller
//@SessionAttributes("nameKey")
public class TodoController {
	@Autowired
	private LoginService service;
	@Autowired
	private TodoService todoService;


	
	//@GetMapping("/list-todo")
	public String todo(String user, Model model) throws ParseException {
		List<Todo> retrieveTodos = todoService.retrieveTodos();
		model.addAttribute("todoKey", retrieveTodos);
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
		return "todolist";
	}

}
