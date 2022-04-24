package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents the right Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOAssetRight implements IAsset{
	private @Id Long id;

	private String name;

	private String units;
	private AssetClass assetClass;
	
	/**
	 * 
	 * @return
	 * @since 0.0.4
	 */
	public DTOAsset toDTOAsset() {
		return DTOAsset.builder()
				.id(id)
				.name(name)
				.units(units)
				.assetClass(assetClass)
				.build();
	}
}
