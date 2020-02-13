package com.wtb.domain.email;

import com.wtb.application.mailResponse.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSpringEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publishEvent(final Mail mail) {
        EmailSpringEvent emailSpringEvent = new EmailSpringEvent(this,mail);
        publisher.publishEvent(emailSpringEvent);
    }
}
