package com.wtb.application.RGBResponse.businessusecase;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RGBResponseService {

    private static ColorRepository colorRepository;
    private static BinColorRepository binColorRepository;
    private static ProductRepository productRepository;

    public RGB create(Long barCode) {
        Product product = productRepository.findByBarcode(barCode);
        System.out.println(product);
        BinColor trashBin = binColorRepository.findByTrashBin(product.getTrashBin());
        Color color = colorRepository.findBy(trashBin.getColorId());
        return new RGB(color.getR(), color.getG(), color.getB());
    }
}
