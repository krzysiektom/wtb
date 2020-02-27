package com.wtb.application.contact;

import com.wtb.domain.email.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * @param contactDto
     * @return wysłano email true / false
     */
    public boolean submitContact(ContactDto contactDto) {
        if (contactDto.getSendEmail()) {
            applicationEventPublisher.publishEvent(new EmailEvent(contactDto));
        }
        return false;
        //TODO save ContactDto in DB
    }
}
