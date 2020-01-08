package com.wtb.domain.binColor;

import com.wtb.domain.buildingblocks.BaseEntity;
import com.wtb.domain.color.Color;
import com.wtb.domain.product.TrashBin;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
public class BinColor extends BaseEntity {
    private TrashBin trashBin;
    @OneToOne
    private Color color;

    public BinColor() {
    }

    public BinColor(TrashBin trashBin, Color color) {
        this.trashBin = trashBin;
        this.color = color;
    }
}
