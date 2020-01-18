package com.wtb.application.shortResponse;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortResponseService {

    private final ProductRepository productRepository;

    public Bin getBinByBarcode(String barcode) {
            Product product = productRepository.findByBarCode(Long.parseLong(barcode));
            return new Bin(product.getTrashBin().ordinal());
    }
}
