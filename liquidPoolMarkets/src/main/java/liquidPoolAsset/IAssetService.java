package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool asset service.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.1
 */
@Service
public interface IAssetService {
	/**
	 * Returns the List containing all assets tracked by this liquid pool
	 * exchange.
	 * 
	 * @return The set containing all assets tracked by this liquid pool
	 *         exchange.
	 * @since 0.0.1
	 */
	List<Asset> getAllAssets();

	/**
	 * Adds a specific asset to be tracked by the liquid pool exchange;
	 * returning true if successful.
	 * 
	 * @param asset The asset to be added.
	 * @return True if the addition was successful.
	 * @since 0.0.2
	 */
	boolean add(Asset asset);

	/**
	 * Removes a specific asset from those to be tracked by the liquid pool
	 * exchange; returning true if successful.
	 * 
	 * @param asset The specified asset to be removed.
	 * @return True if the removal was successful.
	 * @since 0.0.3
	 */
	boolean remove(Asset asset);
}
