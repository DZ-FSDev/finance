package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Candlestick entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.7
 */
public interface ICandlestickRepository extends R2dbcRepository<DTOCandlestick, Long>{
	<T extends ICandlestick> Flux<T> findByMarketIdOrderByOpenTS(Class<T> type, Long marketId);
	<T extends ICandlestick> Mono<T> getByMarketIdOrderByOpenTSDesc(Class<T> type, Long marketId);
}
