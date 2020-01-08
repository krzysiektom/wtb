package com.wtb.infrastructure.db;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface H2ProductRepository extends JpaRepository<Product, Long>, ProductRepository {
    Product findByBarCode(Long barCode);
}
