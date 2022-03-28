package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a liquid {@link Asset} class-based projection containing the
 * units and string identifiers.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOAssetUnit implements IAsset{
	private String name;
	private String symbol;
	private String units;
}
