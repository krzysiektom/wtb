package com.wtb.domain.email;

import com.wtb.application.contact.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender {

    @Value("${spring.mail.username}")
    private String email;

    private final JavaMailSender javaMailSender;

    public void sendEmail(ContactDto contactDto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setCc(contactDto.getEmail());
        msg.setSubject(contactDto.getSubject());
        msg.setText(contactDto.getMessage());

        javaMailSender.send(msg);
    }
}
