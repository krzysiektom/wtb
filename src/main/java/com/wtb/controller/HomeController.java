package com.wtb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"title", "name"})
public class HomeController {
    @Value("${spring.application.title}")
    String title;

    @Value("${spring.application.name}")
    String name;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("name", name);
        return "home";
    }
}
