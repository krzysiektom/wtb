package com.wtb.domain.color;

public interface ColorRepository {
    Color save(Color color);
    Color findBy(Long id);
}
