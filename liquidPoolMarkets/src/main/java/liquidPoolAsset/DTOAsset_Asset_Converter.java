package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.dz_fs_dev.finance.liquidPoolMarkets.Converter;

/**
 * Converts between {@link DTOAsset} and {@link Asset}.
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
		return new DTOAsset(asset.getId(), asset.getSymbol(), asset.getName(), asset.getUnits().toString(), asset.getLastPrice().toString(), asset.getAssetClass());
	}
	
	public static Asset convertToEntity(DTOAsset asset) {
		return new Asset(asset.getId(), asset.getSymbol(), asset.getName(), new BigInteger(asset.getUnits()), new BigDecimal(asset.getLastPrice()), asset.getAssetClass());
	}
}
