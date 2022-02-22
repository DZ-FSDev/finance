package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import lombok.Getter;

/**
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MarketPriceMatrixCellDTO {
	private @Getter String ticker;

	/**
	 * @param ticker
	 */
	public MarketMatrixCellDTO(String ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "MarketMatrixCellDTO [ticker=" + ticker + "]";
	}
	
	
}
