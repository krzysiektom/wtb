package com.wtb.application.barCodeResponse;

import com.wtb.domain.product.ProductBadRequestException;
import com.wtb.domain.product.ProductExistException;
import com.wtb.domain.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BarCodeExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(BarCodeBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String barCodeBadRequestHandler(BarCodeBadRequestException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BarCodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String barCodeNotFoundHandler(BarCodeNotFoundException ex) {
        return ex.getMessage();
    }
}
