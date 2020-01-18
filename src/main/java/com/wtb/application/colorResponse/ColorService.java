package com.wtb.application.colorResponse;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;

    public Color findById(String id) {
        Long idParse;
        try {
            idParse = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            throw new ColorBadRequestException(id);
        }
        return colorRepository.findById(idParse)
                .orElseThrow(() -> new ColorNotFoundException(idParse));
    }
}
