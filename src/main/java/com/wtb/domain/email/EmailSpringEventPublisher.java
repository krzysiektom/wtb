package com.wtb.domain.email;

import com.wtb.application.contact.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSpringEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publishEvent(final ContactDto contactDto) {
        EmailEvent emailEvent = new EmailEvent(contactDto);
        publisher.publishEvent(emailEvent);
    }
}
