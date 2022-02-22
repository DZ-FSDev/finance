package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a matrix of prices that exist in the current market.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MarketPriceMatrixDTO {
	static MarketPriceMatrixDTO cachedInstance;
	
	private @Getter @Setter long timestamp;
	
	
}
