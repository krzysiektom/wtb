package com.wtb.domain.color;

import com.wtb.domain.buildingblocks.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Color extends BaseEntity {
    private String colorName;
    private int r;
    private int g;
    private int b;

    public Color(String colorName, int r, int g, int b) {
        this.colorName = colorName;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color() {
    }
}
