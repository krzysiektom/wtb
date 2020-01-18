package com.wtb.domain.color;

import com.wtb.domain.buildingblocks.BaseEntity;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
public class Color extends BaseEntity {
    @NotBlank(message = "Name is mandatory")
    private String colorName;
    @Min(value = 0, message = "Value must be between 0 and 255")
    @Max(value = 255, message = "Value must be between 0 and 255")
    private int r;
    @Min(value = 0, message = "Value must be between 0 and 255")
    @Max(value = 255, message = "Value must be between 0 and 255")
    private int g;
    @Min(value = 0, message = "Value must be between 0 and 255")
    @Max(value = 255, message = "Value must be between 0 and 255")
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
