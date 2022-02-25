package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.AssetUnitDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a matrix of prices that exist in the current market.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
public class MarketPriceMatrixDTO {
	static MarketPriceMatrixDTO cachedInstance;
	
	private @Getter @Setter long timestamp;
	
	private @Getter @Setter List<AssetUnitDTO> currencies;
	private @Getter @Setter List<AssetUnitDTO> assets;
	
	private @Getter @Setter BigDecimal[][] prices;

	/**
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
