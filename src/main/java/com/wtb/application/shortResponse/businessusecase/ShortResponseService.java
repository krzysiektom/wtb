package com.wtb.application.shortResponse.businessusecase;

import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortResponseService {

    private final ProductRepository productRepository;

    public Bin create(Long barcode){
        return new Bin(productRepository.findByBarcode(barcode).getTrashBin().ordinal());
    }
}
