package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.math.BigInteger;

import lombok.Getter;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class AssetUnitDTO {
	private @Getter String name;
	private @Getter BigInteger units;
	
	/**
	 * @param name
	 * @param units
	 */
	public AssetUnitDTO(String name, BigInteger units) {
		this.name = name;
		this.units = units;
	}
}
