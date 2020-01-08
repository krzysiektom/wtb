package com.wtb.controller;

import com.wtb.application.RGBResponse.businessusecase.RGB;
import com.wtb.application.RGBResponse.businessusecase.RGBResponseService;
import com.wtb.application.shortResponse.businessusecase.Bin;
import com.wtb.application.shortResponse.businessusecase.ShortResponseService;
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

    private final ShortResponseService shortResponseService;
    private final RGBResponseService rgbResponseService;

    @ResponseBody
    @GetMapping("/bin")
    public Bin binByBarcode(@RequestParam(value = "barcode") String barcode) {
        return shortResponseService.create(barcode);
    }
    @ResponseBody
    @GetMapping("/rgb")
    public RGB RGBByBarcode(@RequestParam(value = "barcode") Long barcode) {
        return rgbResponseService.create(barcode);
    }

}
