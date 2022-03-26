package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
 * @version 0.0.5
 */
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LiquidOrder implements ILiquidOrder{
	private @Id Long id;
	
	private Long timestamp;
	private BigInteger units;
	private BigInteger allowableCostBasis;
	
	private Long assetId;
	private Long accountId;
}
