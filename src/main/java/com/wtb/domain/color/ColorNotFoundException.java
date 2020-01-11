package com.wtb.domain.color;

public class ColorNotFoundException extends RuntimeException {
    public ColorNotFoundException(Long id) {
        super("Could not find color with id = " + id);
    }
}
