package com.wtb.domain.product;

public class ProductExistException extends RuntimeException{
    public ProductExistException(Long id) {
        super("Product exist by id = "+ id);
    }
}
