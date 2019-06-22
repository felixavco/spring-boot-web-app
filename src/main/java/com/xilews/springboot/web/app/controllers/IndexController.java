package com.xilews.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("title", "List of users");
		return "user/list";
	}
	
	@ModelAttribute("cities")
	public List<String> getCities() {
		List<String> cities = Arrays.asList(
			"Vancouver", 
			"Surrey", 
			"Calgary", 
			"Ontario", 
			"Quebec", 
			"Saskatchewan"
		);
			
		return cities;
	}
	
	@ModelAttribute("users")
	public List<User> getUsers() {
		List<User> users = Arrays.asList(
				new User(1, "Felix", "Avelar", "felix@gmail.com"),
				new User(2, "Camila", "Avelar", "camila@gmail.com"),
				new User(3, "Brenda", "Marroquin", "brenda@gmail.com"),
				new User(4, "Karla", "Rodriguez", "karla@gmail.com"),
				new User(5, "Emilia", "Rodriguez", "lupi@gmail.com"),
				new User(6, "Mariana", "Rodriguez", "mariana@gmail.com"),
				new User(7, "Denis", "Avelar", "denis@gmail.com")
			);
			
		return users;
	}
}
