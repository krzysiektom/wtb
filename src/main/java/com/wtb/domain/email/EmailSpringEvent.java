package com.wtb.domain.email;

import com.wtb.application.mailResponse.Mail;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmailSpringEvent extends ApplicationEvent {
    private Mail mail;

    public EmailSpringEvent(Object source, Mail mail) {
        super(source);
        this.mail = mail;
    }

}
