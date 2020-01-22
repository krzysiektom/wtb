package com.wtb.domain.product;

public class ProductExistException extends RuntimeException{
    public ProductExistException(Long id) {
        super("Color exist by id = "+ id);
    }
}
