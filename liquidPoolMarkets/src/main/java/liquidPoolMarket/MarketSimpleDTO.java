package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

import lombok.Getter;

/**
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MarketSimpleDTO {
	private @Getter String leftAsset;
	
	private @Getter String rightAsset;
	
	private @Getter String ticker;

	public MarketSimpleDTO(Asset leftAsset, Asset rightAsset, String ticker) {
		this.leftAsset = leftAsset.getName();
		this.rightAsset = rightAsset.getName();
		this.ticker = ticker;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public String toString() {
		return "MarketSimpleDTO [leftAsset=" + leftAsset + ", rightAsset=" + rightAsset + ", ticker=" + ticker + "]";
	}
}
