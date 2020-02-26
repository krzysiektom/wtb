package com.wtb.application.product.barCode;

public class BarCodeBadRequestException extends RuntimeException {
    public BarCodeBadRequestException(String barCode) {super("BareCode is not a number - bareCode = " + barCode);
    }
}
