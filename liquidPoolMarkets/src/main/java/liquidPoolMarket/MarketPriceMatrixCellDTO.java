package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import lombok.Getter;

/**
 * Represents a cell in the Price Matrix.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public class MarketPriceMatrixCellDTO {
	private @Getter String ticker;

	/**
	 * Initializes a new instance of a cell in the Price Matrix.
	 * 
	 * @param ticker The ticker this cell represents.
	 */
	public MarketPriceMatrixCellDTO(String ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "MarketMatrixCellDTO [ticker=" + ticker + "]";
	}
}
