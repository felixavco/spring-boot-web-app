package com.xilews.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store/department")
public class PathVariablesController {
    
    @GetMapping("/{id}")
    public String getDepartment(@PathVariable int id,  Model model) {
        String department; 

        switch (id) {
            case 1:
                department = "Human Resources";
                break;

            case 2:
                department = "Marketing";
                break;
            
            case 3:
                department = "Customer Service";
                break;

            case 4:
                department = "Tech Support IT";
                break;
            
            case 5:
                department = "Web and Software development";
                break;
        
            default:
                department = "Incorrect department ID";
                break;
        }

        model.addAttribute("title", "Departments");
        model.addAttribute("department", department);

        return "store/department/index";
    }

    @GetMapping("/city/{city}")
    public String getCity(@PathVariable String city, Model model) {

        model.addAttribute("title", "City: " + city);
        model.addAttribute("city", city);

        return "store/department/city";
    }

}