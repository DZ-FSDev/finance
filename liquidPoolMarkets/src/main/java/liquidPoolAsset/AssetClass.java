/*  Original Licensing Copyright
 * 
 *  Asset classifications in liquid pool markets.
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

/**
 * Represents the different classifications an Asset in liquid pool markets
 * can have.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public enum AssetClass {
	/**
	 * @since 0.0.1 
	 */
	BASE,
	
	/**
	 * @since 0.0.1 
	 */
	CURRENCY,
	
	/**
	 * @since 0.0.1 
	 */
	BOND,
	
	/**
	 * @since 0.0.1 
	 */
	EQUITY,
	
	/**
	 * @since 0.0.1 
	 */
	COMMODITY
}
