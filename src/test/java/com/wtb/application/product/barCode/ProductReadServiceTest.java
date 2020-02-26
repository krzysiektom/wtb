package com.wtb.application.product.barCode;

import com.wtb.application.product.ProductReadService;
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
class BarCodeResponseServiceTest {
    @InjectMocks
    private ProductReadService tested;

    @Mock
    private ProductRepository mockRepository;

    Product product = new Product(5L, TrashBin.METAL);
    Product product2 = new Product(5L, TrashBin.GLASS);

//    @Test
//    void findByIdStringIsNotNumber() {
//        assertThrows(BarCodeBadRequestException.class, () -> tested.findByBarCode("a"));
//    }

    @Test
    void findByIdWhenColorNotInDB() {
        Mockito.when(mockRepository.findByBarCode(2L)).thenReturn(Optional.empty());
        assertThrows(BarCodeNotFoundException.class, () -> tested.findByBarCode(2L));
    }

    @Test
    void findByIdWhenColorInDB() {
        Mockito.when(mockRepository.findByBarCode(1L)).thenReturn(Optional.of(product));
        assertEquals(product, tested.findByBarCode(1L));
    }

}