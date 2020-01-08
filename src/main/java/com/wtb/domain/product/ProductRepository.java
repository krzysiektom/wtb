package com.wtb.domain.product;

public interface ProductRepository {
    Product findByBarCode(Long barCode);
}
