package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

/**
 * Persistence layer for Liquid Market entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.1
 */
public interface MarketRepository extends JpaRepository<Market, Long>{
	/*
	 *  -- Read --
	 */
	public Optional<Market> findByMarketId(Long marketId);
	public Optional<Market> findByTicker(String ticker);
	public Optional<Market> findByLeftAsset(Asset asset);
	public Optional<Market> findByRightAssetOrderByTicker(Asset asset);
	public Optional<Market> findByTickerLike(String pattern);
	public Optional<Market> findByTickerContainsAllIgnoreCase(String name);
	
	public <T> List<T> findAllByOrderByTicker(Class<T> type);
	
	/*
	public List<Asset> findFirst3OrderByVolume(BigInteger units);
	public List<Asset> findFirst3OrderByPrice(BigInteger units);
	*/
	
	/*
	 *  -- Update --
	 */
	public long deleteByTicker(String ticker);
}
