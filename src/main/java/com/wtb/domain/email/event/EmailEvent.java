package com.wtb.domain.email.event;

import com.wtb.application.contact.ContactDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmailEvent extends ApplicationEvent {
    public EmailEvent(ContactDto contactDto) {
        super(contactDto);
    }
}
