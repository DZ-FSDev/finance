package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents the left Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.5
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOAssetLeft implements IAsset{
	private @Id Long id;

	private String symbol;
	private String name;

	private String units;
	private String lastPrice;
	private AssetClass assetClass;
	
	/**
	 * 
	 * @return
	 * @since 0.0.5
	 */
	public DTOAsset toDTOAsset() {
		return DTOAsset.builder()
				.id(id)
				.symbol(symbol)
				.name(name)
				.units(units)
				.lastPrice(lastPrice)
				.assetClass(assetClass)
				.build();
	}
}
