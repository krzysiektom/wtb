package com.wtb.domain.email;

import com.wtb.application.contact.ContactDto;
import com.wtb.domain.buildingblocks.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Getter
public class Email extends BaseEntity {
    private String email;
    private String name;
    private String subject;
    private String message;
    private Boolean sendEmail;
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public Email(ContactDto contactDto) {
        this.email = contactDto.getEmail();
        this.name = contactDto.getName();
        this.subject = contactDto.getSubject();
        this.message = contactDto.getMessage();
        this.sendEmail = contactDto.getSendEmail();
    }

    public Email() {
    }
}
