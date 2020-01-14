package com.wtb.domain.color;

class ColorBadRequestException extends RuntimeException {
    public ColorBadRequestException(String id){
        super("Id is not a number - id = "+ id);
    }
}
