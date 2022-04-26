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
	/**
	 * 
	 * @param marketId
	 * @return
	 * @since 0.0.1
	 */
	Flux<DTOCandlestick> getCandlesticksByMarketId(Long marketId);
	
	/**
	 * 
	 * @param candle
	 * @return
	 * @since 0.0.2
	 */
	Mono<DTOCandlestick> save(DTOCandlestick candle);
	
	/**
	 * 
	 * @param marketId
	 * @return
	 * @since 0.0.3
	 */
	Mono<DTOCandlestick> getTopByMarketIdOrderByOpenTSDesc(Long marketId);
}
