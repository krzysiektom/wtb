package com.wtb.domain.color;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ColorExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ColorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String colorNotFoundHandler(ColorNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ColorBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String colorBadRequestHandler(ColorBadRequestException ex) {
        return ex.getMessage();
    }
}
