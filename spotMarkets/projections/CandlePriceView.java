package com.dz_fs_dev.finance.spotMarkets.projections;

/**
 * Closed projection to ask and bid close prices of a candle.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 16.0.1
 */
public interface CandlePriceView {
    String getAskClose();
    String getBidClose();
	Long getEndTimeStamp();
}
