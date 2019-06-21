package com.xilews.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xilews.springboot.web.app.models.User;

@Controller
@RequestMapping({"/user", "/app", "/users"})
public class IndexController {

	@GetMapping({ "/", "/home", "/index", "" })
	public String index(Model model) {
		
		model.addAttribute("title", "Spring Framework");
		
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setFirstName("Felix");
		user.setLastName("Avelar");
		user.setEmail("felix@gmail.com");
		
		
		model.addAttribute("title", "Profile " + user.getFirstName());
		model.addAttribute("user", user);
		
		return "user/profile";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<User> users = new ArrayList<>();
		users.add(new User("Felix", "Avelar", "felix@gmail.com"));
		users.add(new User("Camila", "Avelar", "camila@gmail.com"));
		users.add(new User("Brenda", "Marroquin", "brenda@gmail.com"));
		
		model.addAttribute("title", "List of users");
		model.addAttribute("users", users);
		return "user/list";
	}
}
