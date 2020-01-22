package com.wtb.controller;

import com.wtb.application.ProductService;
import com.wtb.application.RGBResponse.RGB;
import com.wtb.application.RGBResponse.RGBResponseService;
import com.wtb.application.shortResponse.Bin;
import com.wtb.application.shortResponse.ShortResponseService;
import com.wtb.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ShortResponseService shortResponseService;
    private final RGBResponseService rgbResponseService;
    private final ProductService productService;

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

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product) throws URISyntaxException {
        Product productSaved = productService.save(product);
        return ResponseEntity.created(new URI("product/" + productSaved.getId())).body(productSaved);
    }

}
