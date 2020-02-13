package com.wtb.application.mailResponse;

import com.wtb.domain.email.EmailSpringEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final EmailSpringEventPublisher publisher;

    public void sendMail(Mail mail) {
        //TODO zapis do DB
        if (mail.getResend()) {
            publisher.publishEvent(mail);
        }
    }

}
