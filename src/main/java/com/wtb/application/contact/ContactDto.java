package com.wtb.application.contact;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class ContactDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String subject;
    @NotBlank
    private String message;

    private Boolean sendEmail;

    public ContactDto(String email, String name, String subject, String message, Boolean sendEmail) {
        this.email = email;
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.sendEmail = sendEmail;
    }
}
