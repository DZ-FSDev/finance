package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Asset in liquid pool markets. Contains the asset class, symbol
 * and name.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOAssetClass implements IAsset{
	private @Id Long id;

	private String symbol;
	private String name;
	private AssetClass assetClass;
}
