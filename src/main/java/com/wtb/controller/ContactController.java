package com.wtb.controller;

import com.wtb.application.mailResponse.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contactPage(@ModelAttribute Mail mail) {
        return "contact";
    }
}
