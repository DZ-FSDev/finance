package com.dz_fs_dev.finance.liquidPoolMarkets.liquidMarketExchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 0.0.7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTOMarketPricing {
	private Long marketId;
	private String ticker;
	
	private Long leftAssetId;
	private Long rightAssetId;
	
	private String leftUnits;
	private String rightUnits;
	
	private double rsi3, rsi3_tmx49;
	private double rsi4, rsi4_tmx49;
	private double rsi5, rsi5_tmx49;
	private double rsi6, rsi6_tmx49;
	private double rsi13, rsi13_tmx49;
	private double rsi14, rsi14_tmx49;
	private double rsi15, rsi15_tmx49;
	private double rsi21, rsi21_tmx49;
	
	private long ts;
}
