package com.wtb.application.bin;

import com.wtb.application.product.barCode.BarCodeBadRequestException;
import com.wtb.application.product.barCode.BarCodeNotFoundException;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BinService {

    private final ProductRepository productRepository;

    public Bin getBinByBarcode(String barCode) {
        Long barCodeParse;
        try {
            barCodeParse = Long.parseLong(barCode);
        } catch (NumberFormatException nfe) {
            throw new BarCodeBadRequestException(barCode);
        }
        Product product = productRepository.findByBarCode(barCodeParse)
                .orElseThrow(() -> new BarCodeNotFoundException(barCodeParse));
        return new Bin(product.getTrashBin().ordinal());
    }
}
