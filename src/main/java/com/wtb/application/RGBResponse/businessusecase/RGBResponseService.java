package com.wtb.application.RGBResponse.businessusecase;

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

    public RGB getRGBByBarcode(Long barCode) {
        Product product = productRepository.findByBarCode(barCode);
        BinColor trashBin = binColorRepository.findByTrashBin(product.getTrashBin());
        Color color = trashBin.getColor();
        return new RGB(color.getR(), color.getG(), color.getB());
    }
}
