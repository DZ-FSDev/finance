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
 * @version 0.0.8
 * @since 17.0.2
 */
public interface AssetRepository extends R2dbcRepository<Asset, Long>{
	/*
	 *  -- Read --
	 */
	public Mono<Asset> findByName(String name);
	public Mono<Asset> findByNameOrderByName(String name);
	public Mono<Asset> findByNameLike(String pattern);
	public Mono<Asset> findByNameEndingWith(String name);
	public Mono<Asset> findByNameStartingWith(String name);
	public Mono<Asset> findByNameContainsAllIgnoreCase(String name);
	
	public Mono<Asset> findByNameOrSymbol(String name, String symbol);
	public Mono<Asset> findByNameContainsOrSymbolContainsAllIgnoreCase(String name, String symbol);
	
	public Mono<Asset> findBySymbol(String symbol);
	public Mono<Asset> findBySymbolOrderBySymbol(String symbol);
	public Mono<Asset> findBySymbolLike(String pattern);

	public <T> Flux<T> findAllByAssetClass(AssetClass assetClass, Class<T> type);
	public <T> Mono<T> findByAssetClass(AssetClass assetClass, Class<T> type);
	public <T> Flux<T> findAllBy(Class<T> type);
	
	public Flux<Asset> findFirst3ByUnitsLessThan(BigInteger units);
	public Flux<Asset> findFirst3ByUnitsGreaterThan(BigInteger units);
	public Flux<Asset> findFirst3ByUnitsBetween(BigInteger unitsLow, BigInteger unitsHigh);
	
	public Flux<Asset> findFirst3ByLastPriceLessThan(BigInteger units);
	public Flux<Asset> findFirst3ByLastPriceGreaterThan(BigInteger units);
	public Flux<Asset> findFirst3ByLastPriceBetween(BigInteger unitsLow, BigInteger unitsHigh);
	
	public Flux<Asset> findFirst3ByMarketCapLessThan(BigInteger marketCap);
	public Flux<Asset> findFirst3ByMarketCapGreaterThan(BigInteger marketCap);
	public Flux<Asset> findFirst3ByMarketCapBetween(BigInteger marketCapLow, BigInteger marketCapHigh);
	
	
	/*
	 *  -- Delete --
	 */
	public long deleteByName(String name);
	public long deleteBySymbol(String name);

}
