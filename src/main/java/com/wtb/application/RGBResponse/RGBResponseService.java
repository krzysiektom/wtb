package com.wtb.application.RGBResponse;

import com.wtb.application.barCodeResponse.BarCodeBadRequestException;
import com.wtb.application.barCodeResponse.BarCodeNotFoundException;
import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.Product;
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
            throw new BarCodeBadRequestException(barCode);
        }
        Product product = productRepository.findByBarCode(barCodeParse).orElseThrow(() -> new BarCodeNotFoundException(barCodeParse));
        BinColor trashBin = binColorRepository.findByTrashBin(product.getTrashBin());
        Color color = trashBin.getColor();
        return new RGB(color.getR(), color.getG(), color.getB());
    }
}
