package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool candlestick service.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.2
 */
@Service
public interface ICandlestickService {
	Flux<DTOCandlestick> getCandlesticksByMarketId(Long marketId);
	
	Mono<DTOCandlestick> save(DTOCandlestick candle);
	
	Mono<DTOCandlestick> getTopByMarketIdOrderByOpenTSDesc(Long marketId);
}
