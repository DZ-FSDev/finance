package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.2
 */
@Data
@Table("asset")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOAsset implements IAsset{
	private @Id Long id;

	private String symbol;
	private String name;

	private String units;
	private String coldUnits;
	
	private String lastPrice;
	private AssetClass assetClass;
}
