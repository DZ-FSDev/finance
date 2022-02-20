package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an liquid {@link Market} update request sent by the web
 * application.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MarketUpdateDTO {
	public @Getter @Setter Market from;
	public @Getter @Setter Market to;
	
	@Override
	public String toString() {
		return "MarketUpdateDTO [from=" + from + ", to=" + to + "]";
	}
}
