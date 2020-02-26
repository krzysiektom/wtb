package com.wtb.application.product;

import com.wtb.application.product.barCode.BarCodeNotFoundException;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductReadService {

    private final ProductRepository productRepository;

    public Product findByBarCode(Long barCode) {
        return productRepository.findByBarCode(barCode).orElseThrow(() -> new BarCodeNotFoundException(barCode));
    }
}
