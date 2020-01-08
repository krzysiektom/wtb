package com.wtb.infrastructure.db;

import com.wtb.domain.binColor.BinColor;
import com.wtb.domain.binColor.BinColorRepository;
import com.wtb.domain.product.TrashBin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2BinColorRepository extends JpaRepository<BinColor, Long>, BinColorRepository {
    BinColor findByTrashBin(TrashBin trashBin);
}
