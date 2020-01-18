package com.wtb.application.RGBResponse;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductBadRequestException;
import com.wtb.domain.product.ProductNotFoundException;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RGBResponseService {

    private final BinColorRepository binColorRepository;
    private final ProductRepository productRepository;

    public RGB getRGBByBarcode(String barCode) {
        Long barCodeParse;
        try {
            barCodeParse = Long.parseLong(barCode);
        } catch (NumberFormatException nfe) {
            throw new ProductBadRequestException(barCode);
        }
        Product product = productRepository.findByBarCode(barCodeParse).orElseThrow(() -> new ProductNotFoundException(barCodeParse));
        BinColor trashBin = binColorRepository.findByTrashBin(product.getTrashBin());
        Color color = trashBin.getColor();
        return new RGB(color.getR(), color.getG(), color.getB());
    }
}
