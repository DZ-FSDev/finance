package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Market entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.6
 */
public interface MarketRepository extends R2dbcRepository<Market, Long>{
	/*
	 *  -- Read --
	 */
	public Mono<Market> findByTicker(String ticker);
	public Mono<Market> findByLeftAsset(Asset asset);
	public Mono<Market> findByRightAssetOrderByTicker(Asset asset);
	public Mono<Market> findByTickerLike(String pattern);
	public Mono<Market> findByTickerContainsAllIgnoreCase(String name);
	
	public <T> Flux<T> findAllByOrderByTicker(Class<T> type);
	
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
