package com.wtb.domain.email;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSpringListener implements ApplicationListener<EmailSpringEvent> {

    private final EmailSender emailSender;

    @Override
    public void onApplicationEvent(EmailSpringEvent event) {
        emailSender.sendEmail(event.getMail());
    }
}
