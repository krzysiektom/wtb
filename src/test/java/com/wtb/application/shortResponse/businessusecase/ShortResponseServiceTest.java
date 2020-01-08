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

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ShortResponseServiceTest {

    @InjectMocks
    private ShortResponseService tested;

    @Mock
    private ProductRepository mockRepository;

    Product product = new Product(1L, TrashBin.PAPER);
    Bin bin = new Bin(0);
    Bin binException = new Bin(-1);

    @Test
    void whenStringIsNotNumber() {
        assertEquals(binException, tested.create("a"));
    }

    @Test
    void whenProductInDB() {
        Mockito.lenient().when(mockRepository.findByBarCode(1L)).thenReturn(product);
        assertEquals(bin, tested.create("1"));
    }

    @Test
    void whenProductNotInDB() {
        Mockito.when(mockRepository.findByBarCode(2L)).thenReturn(null);
        assertEquals(binException, tested.create("2"));
    }
}