package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import com.dz_fs_dev.finance.liquidPoolMarkets.Converter;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public class DTOAsset_Asset_Converter extends Converter<DTOAsset, Asset> {
	
	public DTOAsset_Asset_Converter() {
		super(DTOAsset_Asset_Converter::convertToEntity, DTOAsset_Asset_Converter::convertToDTO);
	}
	
	public static DTOAsset convertToDTO(Asset asset) {
		return null;
	}
	
	public static Asset convertToEntity(DTOAsset asset) {
		return null;
	}
}
