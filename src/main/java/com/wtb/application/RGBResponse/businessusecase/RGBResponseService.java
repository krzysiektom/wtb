package com.wtb.application.RGBResponse.businessusecase;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RGBResponseService {

    private static BinColorRepository binColorRepository;
    private static ProductRepository productRepository;

    public RGB create(Long barCode) {
        System.out.println(barCode);
        Product product = productRepository.findByBarCode(barCode);
        System.out.println(product);
        BinColor trashBin = binColorRepository.findByTrashBin(product.getTrashBin());
        Color color = trashBin.getColor();
        return new RGB(color.getR(), color.getG(), color.getB());
    }
}
