package com.wtb.domain.email;

import com.wtb.application.contact.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class WTBApplicationListener {

    private final EmailSender emailSender;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION, fallbackExecution = true)
    public void onContactSubmit(EmailEvent event) {
        emailSender.sendEmail((ContactDto) event.getSource());
    }

//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION, fallbackExecution = true)
//    public void onContactSubmit(OtherWTBEvent event) {

//    }
}
