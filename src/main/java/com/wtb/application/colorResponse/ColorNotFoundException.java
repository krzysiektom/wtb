package com.wtb.application.colorResponse;

class ColorNotFoundException extends RuntimeException {
    public ColorNotFoundException(Long id) {
        super("Could not find color with id = " + id);
    }
}
