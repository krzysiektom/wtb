package com.wtb.controller;

import com.wtb.application.mailResponse.Mail;
import com.wtb.application.mailResponse.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final MailService mailService;

    @GetMapping("")
    public String contactPage(@ModelAttribute Mail mail) {
        return "contact";
    }

    @PostMapping("")
    public String checkMailInfo(@ModelAttribute @Valid Mail mail, BindingResult result) {
        if (result.hasErrors()) {
            return "contact";
        }
        mailService.sendMail(mail);
        return "results";
    }
}
