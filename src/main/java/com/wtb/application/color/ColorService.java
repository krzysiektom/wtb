package com.wtb.application.color;

import com.wtb.domain.color.*;
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

    public Color save(Color color) {
        Color colorInDB = colorRepository.findByColorName(color.getColorName()).orElse(null);
        if (colorInDB == null) {
            return colorRepository.save(color);
        } else if (colorInDB.equals(color)) {
            return colorInDB;
        }
        throw new ColorExistException(colorInDB.getId());
    }
}
