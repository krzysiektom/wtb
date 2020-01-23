package com.wtb.application;

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
class ProductServiceTest {
    @InjectMocks
    private ProductService tested;

    @Mock
    private ProductRepository mockRepository;

    Product product = new Product(5L, TrashBin.METAL);
    Product product2 = new Product(5L, TrashBin.GLASS);

    @Test
    void saveWhenProductNotInDB() {
        Mockito.when(mockRepository.findByBarCode(5L)).thenReturn(Optional.empty());
        Mockito.when(mockRepository.save(product)).thenReturn(product);
        assertEquals(product, tested.save(product));
    }

    @Test
    void saveWhenProductInDBTheSame() {
        Mockito.when(mockRepository.findByBarCode(5L)).thenReturn(Optional.of(product));
        assertEquals(product, tested.save(product));
    }

    @Test
    void saveWhenColorInDCNoTTheSame() {
        Mockito.when(mockRepository.findByBarCode(5L)).thenReturn(Optional.of(product2));
        assertThrows(ProductExistException.class, () -> tested.save(product));

    }

    @Test
    void findByIdStringIsNotNumber() {
        assertThrows(ProductBadRequestException.class, () -> tested.findById("a"));
    }

    @Test
    void findByIdWhenColorNotInDB() {
        Mockito.when(mockRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> tested.findById("2"));
    }

    @Test
    void findByIdWhenColorInDB() {
        Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(product));
        assertEquals(product, tested.findById("1"));
    }

}