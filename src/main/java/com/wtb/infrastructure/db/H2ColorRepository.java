package com.wtb.infrastructure.db;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface H2ColorRepository extends JpaRepository<Color, Long>, ColorRepository {
    Color save(Color color);

    Optional<Color> findById(Long id);
}
