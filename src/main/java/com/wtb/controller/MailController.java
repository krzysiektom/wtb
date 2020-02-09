package com.wtb.controller;

import com.wtb.application.mailResponse.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("contact")
@RequiredArgsConstructor
public class MailController {


    @PostMapping("")
    public String checkMailInfo(@ModelAttribute @Valid Mail mail, BindingResult result) {
        if (result.hasErrors()) {
            return "contact";
        }
        System.out.println(mail);
        //TODO sending email
        return "results";
    }
}
