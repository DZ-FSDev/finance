/*  Original Licensing Copyright
 * 
 *  Persistence layer for Liquid Asset entities.
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

import java.math.BigInteger;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Asset entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.13
 * @since 17.0.2
 */
public interface IAssetRepository extends R2dbcRepository<DTOAsset, Long>{
	/*
	 *  -- Read --
	 */
	<T extends IAsset> Mono<T> findById(Class<T> type, Long id);
	<T extends IAsset> Mono<T> findByName(Class<T> type, String name);
	<T extends IAsset> Mono<T> findByNameOrderByName(Class<T> type, String name);
	<T extends IAsset> Mono<T> findByNameLike(Class<T> type, String pattern);
	<T extends IAsset> Mono<T> findByNameEndingWith(Class<T> type, String name);
	<T extends IAsset> Mono<T> findByNameStartingWith(Class<T> type, String name);
	<T extends IAsset> Mono<T> findByNameContainsAllIgnoreCase(Class<T> type, String name);
	
	<T extends IAsset> Mono<T> findByNameOrSymbol(Class<T> type, String name, String symbol);
	<T extends IAsset> Mono<T> findByNameContainsOrSymbolContainsAllIgnoreCase(Class<T> type, String name, String symbol);
	
	Mono<Asset> findBySymbol(String symbol);
	Mono<Asset> findBySymbolOrderBySymbol(String symbol);
	Mono<Asset> findBySymbolLike(String pattern);

	<T> Flux<T> findAllByAssetClass(AssetClass assetClass, Class<T> type);
	<T> Mono<T> findByAssetClass(AssetClass assetClass, Class<T> type);
	<T> Flux<T> findAllBy(Class<T> type);
	
	Flux<Asset> findFirst3ByUnitsLessThan(BigInteger units);
	Flux<Asset> findFirst3ByUnitsGreaterThan(BigInteger units);
	Flux<Asset> findFirst3ByUnitsBetween(BigInteger unitsLow, BigInteger unitsHigh);
	
	Flux<Asset> findFirst3ByLastPriceLessThan(BigInteger units);
	Flux<Asset> findFirst3ByLastPriceGreaterThan(BigInteger units);
	Flux<Asset> findFirst3ByLastPriceBetween(BigInteger unitsLow, BigInteger unitsHigh);
	
	/*
	Flux<Asset> findFirst3ByMarketCapLessThan(BigInteger marketCap);
	Flux<Asset> findFirst3ByMarketCapGreaterThan(BigInteger marketCap);
	Flux<Asset> findFirst3ByMarketCapBetween(BigInteger marketCapLow, BigInteger marketCapHigh);
	*/
	
	/*
	 *  -- Delete --
	 */
	Mono<Long> deleteByName(String name);
	Mono<Long> deleteBySymbol(String name);

}
