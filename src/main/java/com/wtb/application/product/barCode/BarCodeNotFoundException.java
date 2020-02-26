package com.wtb.application.product.barCode;

public class BarCodeNotFoundException extends RuntimeException {
    public BarCodeNotFoundException(Long barCode) {
        super("Could not find product with barCode = " + barCode);
    }
}
