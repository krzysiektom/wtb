package com.wtb.infrastructure.db;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2ColorRepository extends JpaRepository<Color, Long>, ColorRepository {
    Color save(Color color);
    Color getById(Long id);
}
