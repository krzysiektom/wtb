package com.wtb.domain.product.exception;

public class ProductExistException extends RuntimeException{
    public ProductExistException(Long id) {
        super("Product exist by id = "+ id);
    }
}
