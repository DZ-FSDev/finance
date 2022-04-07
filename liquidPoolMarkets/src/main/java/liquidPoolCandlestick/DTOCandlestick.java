package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

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
 * @version 0.0.1
 */
@Table("candlestick")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOCandlestick implements ICandlestick{
	private @Id Long id;
	
	private Long openTS;
	private Long closeTS;
	
	private String open;
	private String close;
	private String high;
	private String low;
	
	private String assetVolume;
	private String quoteVolume;
	
	private Long marketId;
}
