package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.math.BigInteger;

import lombok.Getter;

/**
 * Represents a liquid {@link Asset} class-based projection containing the
 * units and string identifiers.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public class AssetUnitDTO {
	private @Getter String name;
	private @Getter String symbol;
	private @Getter BigInteger units;
	
	/**
	 * Initializes an instance of the AssetUnitDTO with a specified name,
	 * symbol and units within the liquid pool.
	 * 
	 * @param name
	 * @param units
	 * @param symbol
	 */
	public AssetUnitDTO(String name, String symbol, BigInteger units) {
		this.name = name;
		this.symbol = symbol;
		this.units = units;
	}
}
