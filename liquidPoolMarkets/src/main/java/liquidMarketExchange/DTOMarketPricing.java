package com.dz_fs_dev.finance.liquidPoolMarkets.liquidMarketExchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 0.0.4
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
	
	private int rsi6;
	private int rsi14;
	
	private long ts;
}
