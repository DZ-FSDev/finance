package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool asset service.
 * 
 * @author DZ-FSDev
 * @version 0.0.8
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
	 * @since 0.0.8
	 */
	Flux<Asset> getAllAssets();

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

	/**
	 * Updates a specific asset tracked by the liquid pool exchange; returning
	 * true if successful.
	 * 
	 * @param from The state which serves as an example to select the record
	 *             for updating.
	 * @param to The state the Asset should be updated to.
	 * @return True if the update was successful.
	 * @since 0.0.4
	 */
	@Transactional
	boolean update(Asset from, Asset to);

	/**
	 * Returns a list of assets which matches a given example asset.
	 * 
	 * @param example The example asset to be matched against.
	 * @return A list of assets which matches a given example asset.
	 * @since 0.0.5
	 */
	List<Asset> findByExample(Example<Asset> example);

	/**
	 * Returns a list of assets which belong to an asset class; a compatible
	 * projection type is to be supplied.
	 * 
	 * @param <T> The type for results to be projected with.
	 * @param assetClass The asset class the results must be a part of.
	 * @param type 
	 * @return A list of assets which belong to an asset class.
	 * @since 0.0.6
	 */
	<T> List<T> findAllByAssetClass(AssetClass assetClass, Class<T> type);

	/**
	 * Returns the list of all assets; a compatible projection type is to be
	 * supplied.
	 * 
	 * @param <T> The type for results to be projected with.
	 * @param type
	 * @return A list of assets which belong to an asset class.
	 * @since 0.0.7
	 */
	<T> List<T> findAllBy(Class<T> type);
}
