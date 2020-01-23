package com.wtb.domain.product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findByBarCode(Long aLong);

    Product save(Product product);

    Optional<Product> findById(Long id);
}
