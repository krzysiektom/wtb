package com.wtb.application.RGBResponse.businessusecase;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
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

    @Mock
    private ColorRepository colorRepository;

    Product product = new Product(1L, TrashBin.PAPER);
    BinColor binColor = new BinColor(1L, TrashBin.PAPER, 1L);
    Color color = new Color(1L, "BLUE", 0, 0, 255);

    RGB blue = new RGB(0, 0, 255);

    @Test
    void whenProductInDB() {
        Mockito.lenient().when(productRepository.findByBarcode(1L)).thenReturn(product);
        Mockito.lenient().when(binColorRepository.findByTrashBin(TrashBin.PAPER)).thenReturn(binColor);
        Mockito.lenient().when(colorRepository.findBy(1L)).thenReturn(color);
        assertEquals(blue, tested.create(1L));
    }
}