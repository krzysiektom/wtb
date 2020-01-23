package com.wtb.domain.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ProductBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String productBadRequestHandler(ProductBadRequestException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String productExistHandler(ProductExistException ex) {
        return ex.getMessage();
    }
}
