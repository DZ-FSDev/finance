package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Candlestick entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.3
 */
public interface CandlestickRepository extends R2dbcRepository<DTOCandlestick, Long>{

}
