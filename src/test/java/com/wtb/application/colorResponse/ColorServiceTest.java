package com.wtb.application.colorResponse;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorBadRequestException;
import com.wtb.domain.color.ColorNotFoundException;
import com.wtb.domain.color.ColorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ColorServiceTest {

    @InjectMocks
    private ColorService tested;

    @Mock
    private ColorRepository mockRepository;

    Color color = new Color("BLUE",0,0,255);

    @Test
    void StringIsNotNumber() {
        assertThrows(ColorBadRequestException.class, () ->tested.findById("a"));
    }

    @Test
    void whenColorNotInDB(){
        Mockito.when(mockRepository.findById(2L)).thenReturn(Optional.ofNullable(null));
        assertThrows(ColorNotFoundException.class,() -> tested.findById("2"));
    }

    @Test
    void whenColorInDB(){
        Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(color));
        assertEquals(color,tested.findById("1"));
    }
}