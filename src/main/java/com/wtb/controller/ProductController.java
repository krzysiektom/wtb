package com.wtb.controller;

import com.wtb.application.RGBResponse.RGB;
import com.wtb.application.RGBResponse.RGBResponseService;
import com.wtb.application.shortResponse.Bin;
import com.wtb.application.shortResponse.ShortResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ShortResponseService shortResponseService;
    private final RGBResponseService rgbResponseService;

    @ResponseBody
    @GetMapping("/bin/{barCode}")
    public ResponseEntity<Bin> binByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(shortResponseService.getBinByBarcode(barCode));
    }

    @ResponseBody
    @GetMapping("/rgb/{barCode}")
    public ResponseEntity<RGB> RGBByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(rgbResponseService.getRGBByBarcode(barCode));
    }

}
