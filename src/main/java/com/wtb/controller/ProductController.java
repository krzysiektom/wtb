package com.wtb.controller;

import com.wtb.application.barCodeResponse.BarCodeResponseService;
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

    private final BarCodeResponseService barCodeResponseService;

    @GetMapping("/barcode")
    public String findByBarCode(@RequestParam("barCode") String barCode, Model model) {
        model.addAttribute(barCodeResponseService.findByBarCode(barCode));
        return "product";
    }

}
