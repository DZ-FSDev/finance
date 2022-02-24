package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Liquid Candlestick entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public interface CandlestickRepository extends JpaRepository<Candlestick, Long>{

}
