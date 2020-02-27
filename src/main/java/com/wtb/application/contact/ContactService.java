package com.wtb.application.contact;

import com.wtb.domain.email.Email;
import com.wtb.domain.email.EmailRepository;
import com.wtb.domain.email.event.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final EmailRepository emailRepository;

    /**
     * @param contactDto
     * @return wysłano email true / false
     */
    public boolean submitContact(ContactDto contactDto) {
        if (contactDto.getSendEmail()) {
            applicationEventPublisher.publishEvent(new EmailEvent(contactDto));
        }
        emailRepository.save(new Email(contactDto));
        return false;
    }
}
