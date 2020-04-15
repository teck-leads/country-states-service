package com.atoz.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atoz.app.model.Todo;
import com.atoz.app.service.TodoService;

@Controller
@SessionAttributes("nameKey")
public class LoginController {
	
	@Autowired
	private TodoService todoService;

	@InitBinder
	public void initiBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@GetMapping("/")
	public String loginMessage(Model model) {
		userNameDisplay(model);
		model.addAttribute("nameKey", getLoggedInUser());
		model.addAttribute("pwdKey", "admin");
		return "welcome";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}
	
	
	private String getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	@GetMapping("/list-todo")
	public String todo(String user, Model model) throws ParseException {
		List<Todo> retrieveTodos = todoService.retrieveTodos();
		model.addAttribute("todoKey", retrieveTodos);
		userNameDisplay(model);
		return "todolist";
	}

	@GetMapping("/add-todo")
	public String showTodo(Model model) {
		userNameDisplay(model);
		return "addtodo";
	}

	private void userNameDisplay(Model model) {
		String name = (String) model.getAttribute("nameKey");
		model.addAttribute("mynameKey", name);
	}

	@PostMapping("/addtodo")
	public String addTodo(Model model, @ModelAttribute Todo todo) throws ParseException {
		userNameDisplay(model);
		if (!StringUtils.isEmpty(todo.getUpdId()) && Integer.parseInt(todo.getUpdId()) > 0) {
			todo.setId(Integer.parseInt(todo.getUpdId()));
			todoService.updateTodo(todo.getId(), todo);
		} else {
			// todo.setTargetDate(new Date());
			todo.setDone(false);
			todoService.addTodo(todo);

		}
		return "redirect:/list-todo";
	}

	@GetMapping("/delete")
	public String showTodo(Model model, @RequestParam("id") int id) {
		userNameDisplay(model);
		todoService.deleteTodo(id);

		return "redirect:/list-todo";
	}

	@GetMapping("/update")
	public String showEditTodo(Model model, @RequestParam("id") int id) {
		Todo todo = todoService.retrieveByIdTodos(id);
		userNameDisplay(model);
		model.addAttribute("idKey", todo.getId());
		model.addAttribute("userKey", todo.getUser());
		model.addAttribute("descKey", todo.getDesc());
		model.addAttribute("dateKey", todo.getTargetDate());

		return "addtodo";
	}

}
