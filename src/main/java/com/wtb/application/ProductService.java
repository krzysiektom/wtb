package com.wtb.application;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductExistException;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        Product productInDB = productRepository.findByBarCode(product.getBarCode()).orElse(null);
        if (productInDB == null) {
            return productRepository.save(product);
        } else if (product.equals(productInDB)) {
            return productInDB;
        } else {
            throw new ProductExistException(productInDB.getId());
        }
    }
}
