package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents the left Asset in liquid pool markets.
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
public class DTOAssetLeft implements IAsset{
	private @Id Long id;

	private String name;

	private String units;
	private AssetClass assetClass;
}
