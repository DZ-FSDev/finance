/*  Original Licensing Copyright
 * 
 *  Interface representing liquid pool asset service functionality.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool asset service.
 * 
 * @author DZ-FSDev
 * @version 0.0.19
 * @since 17.0.2
 */
@Service
public interface IAssetService {
	/**
	 * Returns the List containing all assets tracked by this liquid pool
	 * exchange.
	 * 
	 * @return The set containing all assets tracked by this liquid pool
	 *         exchange.
	 * @since 0.0.12
	 */
	Flux<DTOAsset> getAllAssets();

	/**
	 * Adds a specific asset to be tracked by the liquid pool exchange;
	 * returning true if successful.
	 * 
	 * @param asset The asset to be added.
	 * @return True if the addition was successful.
	 * @since 0.0.11
	 */
	Mono<DTOAsset> add(DTOAsset asset);

	/**
	 * Removes a specific asset from those to be tracked by the liquid pool
	 * exchange; returning true if successful.
	 * 
	 * @param asset The specified asset to be removed.
	 * @return True if the removal was successful.
	 * @since 0.0.15
	 */
	Mono<Boolean> remove(Asset asset);

	/**
	 * Updates a specific asset tracked by the liquid pool exchange; returning
	 * true if successful.
	 * 
	 * @param from The state which serves as an example to select the record
	 *             for updating.
	 * @param to The state the Asset should be updated to.
	 * @return True if the update was successful.
	 * @since 0.0.16
	 */
	Mono<Boolean> update(Asset from, Asset to);

	/**
	 * Returns a list of assets which matches a given example asset.
	 * 
	 * @param example The example asset to be matched against.
	 * @return A list of assets which matches a given example asset.
	 * @since 0.0.17
	 */
	Flux<Asset> findByExample(Example<Asset> example);

	/**
	 * Returns a list of assets which belong to an asset class; a compatible
	 * projection type is to be supplied.
	 * 
	 * @param <T> The type for results to be projected with.
	 * @param assetClass The asset class the results must be a part of.
	 * @param type 
	 * @return A list of assets which belong to an asset class.
	 * @since 0.0.18
	 */
	<T extends IAsset> Flux<T> findAllByAssetClass(AssetClass assetClass, Class<T> type);

	/**
	 * Returns the list of all assets; a compatible projection type is to be
	 * supplied.
	 * 
	 * @param <T> The type for results to be projected with.
	 * @param type
	 * @return A list of assets which belong to an asset class.
	 * @since 0.0.19
	 */
	<T extends IAsset> Flux<T> findAllBy(Class<T> type);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param id
	 * @return
	 * @since 0.0.14
	 */
	<T extends IAsset> Flux<T> findById(Class<T> type, Long id);
}
