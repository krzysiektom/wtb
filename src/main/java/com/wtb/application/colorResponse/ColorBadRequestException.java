package com.wtb.application.colorResponse;

class ColorBadRequestException extends RuntimeException {
    public ColorBadRequestException(String id) {
        super("Id is not a number - id = " + id);
    }
}
