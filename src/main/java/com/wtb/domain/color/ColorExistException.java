package com.wtb.domain.color;

public class ColorExistException extends RuntimeException {
    public ColorExistException(Long id) { super("Color exist by id = "+ id);
    }
}
