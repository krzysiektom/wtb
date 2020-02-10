package com.wtb.domain.buildingblocks;

import com.wtb.application.mailResponse.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailComponent {

    @Value("${spring.mail.username}")
    private String email;

    private final JavaMailSender javaMailSender;

    public void sendEmail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setCc(mail.getEmail());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());

        javaMailSender.send(msg);
    }
}
