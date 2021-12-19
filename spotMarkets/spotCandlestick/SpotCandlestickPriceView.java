package com.dz_fs_dev.finance.spotMarkets.spotCandlestick;

import java.math.BigDecimal;

/**
 * Closed projection to ask and bid close prices of a spot candle.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotCandlePriceView {
	BigDecimal getAskClose();
	BigDecimal getBidClose();
	BigDecimal getclose();
	Long getOpenTimeStamp();
	Long getCloseTimeStamp();
}
