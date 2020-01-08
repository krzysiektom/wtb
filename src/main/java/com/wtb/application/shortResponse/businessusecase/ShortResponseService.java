package com.wtb.application.shortResponse.businessusecase;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortResponseService {

    private final ProductRepository productRepository;

    public Bin create(String barcode) {
        try {
            Product product = productRepository.findByBarCode(Long.parseLong(barcode));
            return new Bin(product.getTrashBin().ordinal());
        } catch (Exception e) {
            return new Bin(-1);
        }
    }
}
