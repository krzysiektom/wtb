package com.wtb.application.RGBResponse.businessusecase;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.Product;
import com.wtb.domain.product.ProductRepository;
import com.wtb.domain.product.TrashBin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RGBResponseServiceTest {

    @InjectMocks
    private RGBResponseService tested;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private BinColorRepository binColorRepository;

    Color color = new Color("BLUE", 0, 0, 255);
    BinColor binColor = new BinColor(TrashBin.PAPER, color);
    Product product = new Product(1L, TrashBin.PAPER);

    RGB blue = new RGB(0, 0, 255);

    @Test
    void whenProductInDB() {
        Mockito.lenient().when(productRepository.findByBarCode(1L)).thenReturn(product);
        Mockito.lenient().when(binColorRepository.findByTrashBin(product.getTrashBin())).thenReturn(binColor);
        assertEquals(blue, tested.getRGBByBarcode(1L));
    }
}