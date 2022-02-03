package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool asset service.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Service
public interface IAssetService {
	/**
	 * Returns the set containing all assets tracked by this liquid pool
	 * exchange.
	 * 
	 * @return The set containing all assets tracked by this liquid pool
	 * exchange.
	 * @since 0.0.1
	 */
	Set<Asset> getAllAssets();
	
}
