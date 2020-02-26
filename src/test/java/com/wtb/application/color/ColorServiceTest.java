package com.wtb.application.color;

import com.wtb.domain.color.*;
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
class ColorServiceTest {

    @InjectMocks
    private ColorService tested;

    @Mock
    private ColorRepository mockRepository;

    Color color = new Color("BLUE", 0, 0, 255);
    Color colorBlue2 = new Color("BLUE", 0, 12, 255);

    @Test
    void findByIdStringIsNotNumber() {
        assertThrows(ColorBadRequestException.class, () -> tested.findById("a"));
    }

    @Test
    void findByIdWhenColorNotInDB() {
        Mockito.when(mockRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ColorNotFoundException.class, () -> tested.findById("2"));
    }

    @Test
    void findByIdWhenColorInDB() {
        Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(color));
        assertEquals(color, tested.findById("1"));
    }

    @Test
    void saveWhenColorNotInDB() {
        Mockito.when(mockRepository.findByColorName("BLUE")).thenReturn(Optional.empty());
        Mockito.when(mockRepository.save(color)).thenReturn(color);
        assertEquals(color, tested.save(color));
    }

    @Test
    void saveWhenColorInDBTheSame() {
        Mockito.when(mockRepository.findByColorName("BLUE")).thenReturn(Optional.of(color));
        assertEquals(color, tested.save(color));
    }

    @Test
    void saveWhenColorInDBButNotTheSame() {
        Mockito.when(mockRepository.findByColorName("BLUE")).thenReturn(Optional.of(colorBlue2));
        assertThrows(ColorExistException.class, () -> tested.save(color));
    }
}