package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

import lombok.Getter;

/**
 * Represents a simple read-only class-based projection of the liquid pool
 * {@link Market} entity. Contains a the name of the left and right assets
 * along with the ticker.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MarketSimpleDTO {
	private @Getter String leftAsset;
	
	private @Getter String rightAsset;
	
	private @Getter String ticker;

	/**
	 * Initializes a new instance of a {@link MarketSimpleDTO} which contains
	 * the name of the left and right asset as well as the ticker for the
	 * liquid pool {@link Market} entity it represents.
	 * 
	 * @param leftAsset The name of the left asset in this liquid pool market.
	 * @param rightAsset The name of the right asset in this liquid pool market.
	 * @param ticker The ticker of the market.
	 */
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
