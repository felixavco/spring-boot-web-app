package com.xilews.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xilews.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
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
		
		model.addAttribute("title", "Profile " + user.getFirstName());
		model.addAttribute("user", user);
		
		return "user/profile";
	}
}
