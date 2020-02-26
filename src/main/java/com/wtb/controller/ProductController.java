package com.wtb.controller;

import com.wtb.application.product.ProductReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductReadService productReadService;

    @GetMapping("/barcode")
    public String findByBarCode(@RequestParam("barCode") Long barCode, Model model) {
        model.addAttribute(productReadService.findByBarCode(barCode));
        return "product"; //TODO page product
    }

}
