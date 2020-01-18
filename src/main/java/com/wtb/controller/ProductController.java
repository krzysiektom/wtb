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
    @GetMapping("/bin/{barcode}")
    public ResponseEntity<Bin> binByBarcode(@PathVariable("barcode") String barcode) {
        Bin bin;
        try {
            bin = shortResponseService.getBinByBarcode(barcode);
        } catch (NumberFormatException nfe) {
            return ResponseEntity.badRequest().build();
        } catch (NullPointerException npe) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bin);
    }

    @ResponseBody
    @GetMapping("/rgb/{barcode}")
    public ResponseEntity<RGB> RGBByBarcode(@PathVariable("barcode") String barcode) {
        RGB rgb;
        try {
            rgb = rgbResponseService.getRGBByBarcode(barcode);
        } catch (NumberFormatException nfe) {
            return ResponseEntity.badRequest().build();
        } catch (NullPointerException npe) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rgb);
    }

}
