package com.wtb.domain.product;

public class ProductBadRequestException extends RuntimeException {
    public ProductBadRequestException(String id) {
        super("Id is not a number - id = " + id);
    }
}
