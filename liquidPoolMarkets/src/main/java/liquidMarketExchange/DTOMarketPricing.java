package com.dz_fs_dev.finance.liquidPoolMarkets.liquidMarketExchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 0.0.5
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
	
	private int rsi6, rsi6_tmx13;
	private int rsi14, rsi14_tmx13;
	
	private long ts;
}
