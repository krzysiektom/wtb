package com.wtb.application.barCodeResponse;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarCodeResponseService {

    private final ProductRepository productRepository;

    public Product findByBarCode(String barCode) {
        Long barCodeParse;
        try {
            barCodeParse = Long.parseLong(barCode);
        } catch (NumberFormatException nfe) {
            throw new BarCodeBadRequestException(barCode);
        }
        return productRepository.findByBarCode(barCodeParse).orElseThrow(() -> new BarCodeNotFoundException(barCodeParse));
    }
}
