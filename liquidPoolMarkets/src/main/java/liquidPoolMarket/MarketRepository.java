package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.util.List;
import java.util.Optional;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

/**
 * Persistence layer for Liquid Market entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.5
 */
public interface MarketRepository extends R2dbcRepository<Market, Long>{
	/*
	 *  -- Read --
	 */
	public Optional<Market> findByTicker(String ticker);
	public Optional<Market> findByLeftAsset(Asset asset);
	public Optional<Market> findByRightAssetOrderByTicker(Asset asset);
	public Optional<Market> findByTickerLike(String pattern);
	public Optional<Market> findByTickerContainsAllIgnoreCase(String name);
	
	public <T> List<T> findAllByOrderByTicker(Class<T> type);
	
	@Query("select id from Market")
	List<Long> getAllIds();
	
	/*
	public List<Market> findFirst3OrderByVolume(BigInteger units);
	public List<Market> findFirst3OrderByPrice(BigInteger units);
	*/
	
	/*
	 *  -- Delete --
	 */
	public long deleteByTicker(String ticker);
}
