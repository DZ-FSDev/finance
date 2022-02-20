package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an liquid {@link Asset} update request sent by the web
 * application.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class AssetUpdateDTO {
	public @Getter @Setter Asset from;
	public @Getter @Setter Asset to;
	
	@Override
	public String toString() {
		return "AssetUpdateDTO [from=" + from + ", to=" + to + "]";
	}
}
