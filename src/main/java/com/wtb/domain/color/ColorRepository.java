package com.wtb.domain.color;

import java.util.Optional;

public interface ColorRepository {
    Color save(Color color);

    Optional<Color> findById(Long id);

    Optional<Color> findByColorName(String colorName);

}
