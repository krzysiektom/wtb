package com.wtb.application.shortResponse.businessusecase;

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
