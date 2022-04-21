package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Candlestick entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.5
 */
public interface ICandlestickRepository extends R2dbcRepository<DTOCandlestick, Long>{
	<T extends ICandlestick> Flux<T> findByMarketId(Class<T> type, Long marketId);
}
