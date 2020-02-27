package com.wtb.domain.email.event;

import lombok.Data;

@Data
public class EmailEventDto {
//    private final String from;
    private final String to;
    private final String subject;
    private final String body;

    private final Type type;

    enum Type {
        CONTACT_CONFIRMATION
    }
}
