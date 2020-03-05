package com.wtb.controller;

import com.wtb.application.contact.ContactService;
import com.wtb.application.contact.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final ContactService contactService;

    @GetMapping("")
    public String contactPage(@ModelAttribute ContactDto contactDto) {
        return "contact";
    }

    @PostMapping("")
    public String submit(@ModelAttribute @Valid ContactDto contactDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }
        contactService.submitContact(contactDto);
        return "results";
    }
}
