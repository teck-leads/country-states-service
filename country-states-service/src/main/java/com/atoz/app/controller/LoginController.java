package com.atoz.app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atoz.app.model.Todo;
import com.atoz.app.service.LoginService;
import com.atoz.app.service.TodoService;

@Controller
@SessionAttributes("nameKey")
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private TodoService todoService;
	
	@InitBinder
	public void initiBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@GetMapping("/login")
	public String loginMessage(ModelMap model) {
		return "login";
	}

	@PostMapping("/login")
	public String welcome(ModelMap model, @RequestParam("userName") String name, @RequestParam("password") String pwd) {
		model.addAttribute("nameKey", name);
		model.addAttribute("pwdKey", pwd);
		if (!service.validateUser(name, pwd)) {
			return "login";
		}

		return "welcome";
	}
	
	@GetMapping("/list-todo")
	public String todo(String user, Model model) throws ParseException {
		List<Todo> retrieveTodos = todoService.retrieveTodos();
		model.addAttribute("todoKey", retrieveTodos);
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
		return "todolist";
	}
	
	
	@GetMapping("/add-todo")
	public String showTodo(Model model) {
		//todoService.addTodo(todo);
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
		return "addtodo";
	}
	
	@PostMapping("/addtodo")
	public String addTodo(Model model, @ModelAttribute Todo todo) throws ParseException {
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
		if (!StringUtils.isEmpty(todo.getUpdId()) && Integer.parseInt(todo.getUpdId()) > 0) {
			todo.setId(Integer.parseInt(todo.getUpdId()));
			todoService.updateTodo(todo.getId(), todo);
		} else {
			//todo.setTargetDate(new Date());
			todo.setDone(false);
			todoService.addTodo(todo);

		}
		return "redirect:/list-todo";
	}
	
//	@PostMapping("/addtodo")
//	public String addTodo(Model model, @RequestParam("desc") String desc ) {
//		Todo todo=new Todo();
//		todo.setUser("madhav");
//		todo.setDesc(desc);
//		todo.setTargetDate(new Date());
//		todo.setDone(false);
//		todoService.addTodo(todo);
//		String name = (String) model.getAttribute("nameKey");
//		model.addAttribute("mynameKey", name);
//
//		return "redirect:/list-todo";
//	}
	
	@GetMapping("/delete")
	public String showTodo(Model model,@RequestParam("id") int id) {
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
		todoService.deleteTodo(id);
		
		return "redirect:/list-todo";
	}
	@GetMapping("/update")
	public String showEditTodo(Model model,@RequestParam("id") int id) {
		String name = (String) model.getAttribute("nameKey");
		Todo todo = todoService.retrieveByIdTodos(id);
		model.addAttribute("mynameKey", name);
		model.addAttribute("idKey", todo.getId());
		model.addAttribute("userKey",todo.getUser());
		model.addAttribute("descKey", todo.getDesc());
		model.addAttribute("dateKey", todo.getTargetDate());
		
		return "addtodo";
	}
	

}
