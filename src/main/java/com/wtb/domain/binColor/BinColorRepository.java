package com.wtb.domain.binColor;

import com.wtb.domain.product.TrashBin;

public interface BinColorRepository {
    BinColor findByTrashBin(TrashBin trashBin);
}
