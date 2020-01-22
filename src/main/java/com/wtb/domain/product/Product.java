package com.wtb.domain.product;

import com.wtb.domain.buildingblocks.BaseEntity;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

@Entity
@Getter
public class Product extends BaseEntity {
    @NotBlank(message = "BarCode is mandatory")
    private Long barCode;
    private TrashBin trashBin;

    public Product(Long barCode, TrashBin trashBin) {
        this.barCode = barCode;
        this.trashBin = trashBin;
    }

    public Product() {
    }
}
