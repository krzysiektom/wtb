package com.wtb.application.product.bin;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Bin {
    private int bin;

    public Bin(int bin) {
        this.bin = bin;
    }
}
