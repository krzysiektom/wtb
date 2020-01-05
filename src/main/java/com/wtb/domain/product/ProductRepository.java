package com.wtb.domain.product;

public interface ProductRepository {
    Product findByBarcode(Long barcode);
}
