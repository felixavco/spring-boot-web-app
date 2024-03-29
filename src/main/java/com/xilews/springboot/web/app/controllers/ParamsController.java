package com.xilews.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/store")
public class ParamsController {
    
    //* Make the parameter required
    @GetMapping("/search") 
    public String searchStore(@RequestParam(value = "item", required = false) String item,  Model model) {
        
        model.addAttribute("result", item);
        return "store/search";
    }

    //* Using Request params with default value or required
    @GetMapping("/location") 
    public String searchLocation(@RequestParam(name="location", defaultValue = "Apopa") String location,  Model model) {
        
        model.addAttribute("result", location);
        return "store/location";
    }
    
    @GetMapping("/order")
    public String setOrder(@RequestParam(name = "item", required = false) String item, @RequestParam(name = "price", defaultValue = "1.00") Double price, Model model ) {
    	model.addAttribute("item", item);
    	model.addAttribute("price", price);
    	return "store/order";
    }

    //* Using HttpServletRequest
    @GetMapping("/category")
    public String getCategory(HttpServletRequest request,  Model model) {
        Integer qty = null;
        String category = null;

        try {
            category = request.getParameter("category");
            qty = Integer.parseInt(request.getParameter("qty"));
        } catch (NumberFormatException e) {
            qty = 0;
        }

        model.addAttribute("category", category);
        model.addAttribute("qty", qty);
       
        return "store/category";
    }
}