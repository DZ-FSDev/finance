/*  Original Licensing Copyright
 * 
 *  Persistence layer for Spot Candlestick entities.
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
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Spot Candlestick entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.1
 */
public interface AssetRepository extends JpaRepository<Asset, Long>{
	/*
	 *  -- Read --
	 */
	public Optional<Asset> findByAssetId(Long assetId);
	
	public Optional<Asset> findByName(String name);
	public Optional<Asset> findByNameOrderByName(String name);
	public Optional<Asset> findByNameLike(String pattern);
	public Optional<Asset> findByNameEndingWith(String name);
	public Optional<Asset> findByNameStartingWith(String name);
	public Optional<Asset> findByNameContainsAllIgnoreCase(String name);
	
	public Optional<Asset> findBySymbol(String symbol);
	public Optional<Asset> findBySymbolOrderBySymbol(String symbol);
	public Optional<Asset> findBySymbolLike(String pattern);
	public Optional<Asset> findByNameOrSymbol(String name, String symbol);
	public Optional<Asset> findByNameContainsOrSymbolContainsAllIgnoreCase(String name, String symbol);
	
	public List<Asset> findFirst3ByUnitsLessThan(BigInteger units);
	public List<Asset> findFirst3ByUnitsGreaterThan(BigInteger units);
	public List<Asset> findFirst3ByUnitsBetween(BigInteger unitsLow, BigInteger unitsHigh);
	
	/*
	 *  -- Delete --
	 */
	public long deleteByName(String name);
	public long deleteBySymbol(String name);
}
