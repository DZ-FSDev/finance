package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.util.List;

/**
 * Persistence layer for Liquid Market entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface MarketRepository {
	/*
	 *  -- Read --
	 */
	List<Market> findAll();
	
	/*
	 *  -- Update --
	 */
}
