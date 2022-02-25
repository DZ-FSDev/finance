/*  Original Licensing Copyright
 * 
 *  Represents a matrix of prices in a liquid pool market.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.AssetUnitDTO;

import lombok.Getter;

/**
 * Represents a matrix of prices that exist in a liquid pool market.
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
	 * @param currencies The list of currencies in the price matrix.
	 * @param assets The list of assets priced against the currencies in the price matrix.
	 * @param prices The 2D array of prices that map between the currencies and assets.
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
