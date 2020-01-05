package com.wtb.domain.product;

import lombok.Getter;

@Getter
public class Product {
    private Long ID;
    private Long barCode;
    private TrashBin trashBin;

    public Product(Long ID, Long barCode, TrashBin trashBin) {
        this.ID = ID;
        this.barCode = barCode;
        this.trashBin = trashBin;
    }
}
