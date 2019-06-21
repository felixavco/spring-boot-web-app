package com.xilews.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "/", "/home", "/index" })
	public String index(Model model) {
		
		model.addAttribute("title", "Spring Framework");
		
		return "index";
	}
}
