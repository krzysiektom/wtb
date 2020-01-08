package com.wtb.application.shortResponse.businessusecase;

import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortResponseService {

    private final ProductRepository productRepository;

    public Bin create(String barcode) {
        try {
            return new Bin(productRepository.findByBarCode(Long.parseLong(barcode))
                    .getTrashBin().ordinal());
        } catch (Exception e) {
            return new Bin(-1);
        }
    }
}
