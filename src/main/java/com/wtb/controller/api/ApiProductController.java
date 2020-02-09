package com.wtb.controller.api;

import com.wtb.application.ProductService;
import com.wtb.application.RGBResponse.RGB;
import com.wtb.application.RGBResponse.RGBResponseService;
import com.wtb.application.barCodeResponse.BarCodeResponseService;
import com.wtb.application.binResponse.Bin;
import com.wtb.application.binResponse.BinResponseService;
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
public class ApiProductController {

    private final BinResponseService binResponseService;
    private final RGBResponseService rgbResponseService;
    private final BarCodeResponseService barCodeResponseService;
    private final ProductService productService;

    @GetMapping("/barcode/{barCode}")
    public ResponseEntity<Product> findByBarCode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(barCodeResponseService.findByBarCode(barCode));
    }

    @GetMapping("/barcode")
    public ResponseEntity<Product> findByBarCodeR(@RequestParam("barCode") String barCode) {
        return ResponseEntity.ok(barCodeResponseService.findByBarCode(barCode));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product) throws URISyntaxException {
        Product productSaved = productService.save(product);
        return ResponseEntity.created(new URI("product/" + productSaved.getId())).body(productSaved);
    }

    @GetMapping("/bin/{barCode}")
    public ResponseEntity<Bin> binByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(binResponseService.getBinByBarcode(barCode));
    }

    @GetMapping("/rgb/{barCode}")
    public ResponseEntity<RGB> RGBByBarcode(@PathVariable("barCode") String barCode) {
        return ResponseEntity.ok(rgbResponseService.getRGBByBarcode(barCode));
    }

}
