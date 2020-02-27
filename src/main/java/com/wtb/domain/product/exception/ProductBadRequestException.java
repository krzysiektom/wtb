package com.wtb.domain.product.exception;

public class ProductBadRequestException extends RuntimeException {
    public ProductBadRequestException(String id) {
        super("Id is not a number - id = " + id);
    }
}
