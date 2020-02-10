package com.wtb.application.mailResponse;

import com.wtb.domain.buildingblocks.EmailComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final EmailComponent emailComponent;

    public void sendMail(Mail mail) {
        //TODO zapis do DB
        if (mail.getResend()) {
            emailComponent.sendEmail(mail);
        }
    }

}
