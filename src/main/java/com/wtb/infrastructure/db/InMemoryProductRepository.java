package com.wtb.infrastructure.db;

import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import com.wtb.domain.product.TrashBin;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class InMemoryProductRepository implements ProductRepository {

    private HashMap<Long, Product> productHashMap = new HashMap<>();

    {
        productHashMap.put(1L, new Product(1L, TrashBin.PAPER));
        productHashMap.put(2L, new Product(2L, TrashBin.PLASTIC));
    }

    @Override
    public Product findByBarcode(Long barcode) {
        return productHashMap.get(barcode);
    }
}