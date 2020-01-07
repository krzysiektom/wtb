package com.wtb.domain.product;

import com.wtb.domain.buildingblocks.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Product extends BaseEntity {
    private Long barCode;
    private TrashBin trashBin;

    public Product(Long barCode, TrashBin trashBin) {
        this.barCode = barCode;
        this.trashBin = trashBin;
    }

    public Product() {
    }
}
