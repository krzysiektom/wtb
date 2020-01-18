package com.wtb.application.shortResponse;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductBadRequestException;
import com.wtb.domain.product.ProductNotFoundException;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortResponseService {

    private final ProductRepository productRepository;

    public Bin getBinByBarcode(String barCode) {
        Long barCodeParse;
        try {
            barCodeParse = Long.parseLong(barCode);
        } catch (NumberFormatException nfe) {
            throw new ProductBadRequestException(barCode);
        }
        Product product = productRepository.findByBarCode(barCodeParse)
                .orElseThrow(() -> new ProductNotFoundException(barCodeParse));
        return new Bin(product.getTrashBin().ordinal());
    }
}
