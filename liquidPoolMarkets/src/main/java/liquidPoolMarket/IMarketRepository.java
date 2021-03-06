package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Market entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.9
 */
public interface IMarketRepository extends R2dbcRepository<Market, Long>{
	/*
	 *  -- Read --
	 */
	Mono<Market> findByTicker(String ticker);
	Mono<Market> findByLeftAssetId(Long leftAssetId);
	Mono<Market> findByRightAssetIdOrderByTicker(Long rightAssetId);
	Mono<Market> findByTickerLike(String pattern);
	Mono<Market> findByTickerContainsAllIgnoreCase(String name);
	
	<T> Flux<T> findAllByOrderByTicker(Class<T> type);
	
	@Query("select id from Market")
	Flux<Long> getAllIds();
	
	/*
	public Flux<Market> findFirst3OrderByVolume(BigInteger units);
	public Flux<Market> findFirst3OrderByPrice(BigInteger units);
	*/
	
	/*
	 *  -- Delete --
	 */
	public long deleteByTicker(String ticker);
}
