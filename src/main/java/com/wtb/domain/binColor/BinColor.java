package com.wtb.domain.binColor;

import com.wtb.domain.product.TrashBin;
import lombok.Getter;

@Getter
public class BinColor {
    private Long id;
    private TrashBin trashBin;
    private Long colorId;

    public BinColor(Long id, TrashBin trashBin, Long colorId) {
        this.id = id;
        this.trashBin = trashBin;
        this.colorId = colorId;
    }
}
