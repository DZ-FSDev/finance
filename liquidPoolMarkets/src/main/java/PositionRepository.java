package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Liquid Position entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public interface PositionRepository extends JpaRepository<Position, Long>{

}
