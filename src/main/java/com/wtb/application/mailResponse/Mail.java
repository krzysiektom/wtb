package com.wtb.application.mailResponse;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class Mail {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String subject;
    @NotBlank
    private String message;

    private Boolean resend = false;

    public Mail(String email, String name, String subject, String message, Boolean resend) {
        this.email = email;
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.resend = resend;
    }
}
