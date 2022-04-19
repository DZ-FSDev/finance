package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

/**
 * Represents the statuses a {@link LiquidOrder} can have.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.2
 */
public enum OrderStatus {
	NEW,
	NSF,
	
	PLACED,
	
	FILLED
}
