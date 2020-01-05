package com.wtb.controller;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @ResponseBody
    @GetMapping()
    public Product productByBarcode(@RequestParam(value = "barcode",required = true) Long barcode){
        return productRepository.findByBarcode(barcode);
    }
}
