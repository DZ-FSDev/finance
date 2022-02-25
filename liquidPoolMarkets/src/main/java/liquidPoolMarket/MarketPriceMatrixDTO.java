package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.AssetUnitDTO;

import lombok.Getter;

/**
 * Represents a matrix of prices that exist in the current liquid pool market.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
public class MarketPriceMatrixDTO {
	static MarketPriceMatrixDTO cachedInstance;
	
	private @Getter long timestamp;
	
	private @Getter List<AssetUnitDTO> currencies;
	private @Getter List<AssetUnitDTO> assets;
	
	private @Getter BigDecimal[][] prices;

	/**
	 * Initializes a new instance of a matrix of prices that exist in the current liquid pool market.
	 * 
	 * @param currencies
	 * @param assets
	 * @param prices
	 */
	public MarketPriceMatrixDTO(List<AssetUnitDTO> currencies, List<AssetUnitDTO> assets, BigDecimal[][] prices) {
		this.currencies = currencies;
		this.assets = assets;
		this.prices = prices;
		
		this.timestamp = System.currentTimeMillis();
	}

	/**
	 * @since 0.0.3
	 */
	@Override
	public String toString() {
		return "MarketPriceMatrixDTO [timestamp=" + timestamp + ", currencies=" + currencies + ", otherAssets="
				+ assets + ", prices=" + Arrays.toString(prices) + "]";
	}
}
