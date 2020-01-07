package com.wtb.domain.color;

import lombok.Getter;

@Getter
public class Color {
    private Long id;
    private String colorName;
    private int r;
    private int g;
    private int b;

    public Color(Long id, String colorName, int r, int g, int b) {
        this.id = id;
        this.colorName = colorName;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
