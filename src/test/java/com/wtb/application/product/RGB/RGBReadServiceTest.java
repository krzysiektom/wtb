package com.wtb.application.product.RGB;

import com.wtb.domain.product.barCode.BarCodeBadRequestException;
import com.wtb.domain.product.barCode.BarCodeNotFoundException;
import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RGBReadServiceTest {

    @InjectMocks
    private RGBReadService tested;

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
        Mockito.when(productRepository.findByBarCode(1L)).thenReturn(Optional.of(product));
        Mockito.when(binColorRepository.findByTrashBin(product.getTrashBin())).thenReturn(binColor);
        assertEquals(blue, tested.getRGBByBarCode("1"));
    }

    @Test
    void whenProductNotInDB() {
        Mockito.when(productRepository.findByBarCode(1L)).thenReturn(Optional.ofNullable(null));
        assertThrows(BarCodeNotFoundException.class, () -> tested.getRGBByBarCode("1"));
    }

    @Test
    void whenStringIsNotNumber() {
        assertThrows(BarCodeBadRequestException.class, () -> tested.getRGBByBarCode("a"));
    }

}