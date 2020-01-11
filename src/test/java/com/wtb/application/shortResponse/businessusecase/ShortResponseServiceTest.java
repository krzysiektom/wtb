package com.wtb.application.shortResponse.businessusecase;

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
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ShortResponseServiceTest {

    @InjectMocks
    private ShortResponseService tested;

    @Mock
    private ProductRepository mockRepository;

    Product product = new Product(1L, TrashBin.PAPER);
    Bin bin = new Bin(0);

    @Test
    void whenStringIsNotNumber() {
        assertThrows(NumberFormatException.class, () -> tested.getBinByBarcode("a"));
    }

    @Test
    void whenProductInDB() {
        Mockito.lenient().when(mockRepository.findByBarCode(1L)).thenReturn(product);
        assertEquals(bin, tested.getBinByBarcode("1"));
    }

    @Test()
    void whenProductNotInDB() {
        Mockito.when(mockRepository.findByBarCode(2L)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> tested.getBinByBarcode("2"));
    }
}