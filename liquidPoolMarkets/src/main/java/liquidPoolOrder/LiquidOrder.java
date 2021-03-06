package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Order placed in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LiquidOrder implements ILiquidOrder{
	private Long id;
	
	private Long ts;
	private OrderStatus status;
	
	private BigInteger units;
	private BigInteger allowableCostBasis;
	
	private Long marketId;
	private Long accountId;
}
