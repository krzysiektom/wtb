package com.wtb.controller.api;

import com.wtb.application.product.ProductWriteService;
import com.wtb.application.product.RGB.RGB;
import com.wtb.application.product.RGB.RGBReadService;
import com.wtb.application.product.ProductReadService;
import com.wtb.application.product.bin.Bin;
import com.wtb.application.product.bin.BinService;
import com.wtb.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductRest {

    private final BinService binService;
    private final RGBReadService rgbReadService;
    private final ProductReadService productReadService;
    private final ProductWriteService productWriteService;

    @GetMapping("/barcode/{barCode}")
    public ResponseEntity<Product> findByBarCode(@PathVariable("barCode") Long barCode) {
        return ResponseEntity.ok(productReadService.findByBarCode(barCode));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product) throws URISyntaxException {
        Product productSaved = productWriteService.save(product);
        return ResponseEntity.created(new URI("product/" + productSaved.getId())).body(productSaved);
    }

    @GetMapping("/bin/{barCode}")
    public ResponseEntity<Bin> binByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(binService.getBinByBarcode(barCode));
    }

    @GetMapping("/rgb/{barCode}")
    public ResponseEntity<RGB> RGBByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(rgbReadService.getRGBByBarCode(barCode));
    }

}
