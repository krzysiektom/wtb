package com.wtb.infrastructure.db;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface H2ProductRepository extends JpaRepository<Product, Long>, ProductRepository {
    Optional<Product> findByBarCode(Long aLong);

    Product save(Product product);
}
