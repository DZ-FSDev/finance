package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a candlestick in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.5
 */
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candlestick implements ICandlestick{
	private @Id Long id;
	
	private Long openTS;
	private Long closeTS;
	
	private BigDecimal open;
	private BigDecimal close;
	private BigDecimal high;
	private BigDecimal low;
	
	private BigDecimal assetVolume;
	private BigDecimal quoteVolume;
	
	private Long marketId;
}
