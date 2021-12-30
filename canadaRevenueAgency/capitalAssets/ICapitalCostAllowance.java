/*  Modifications Licensing Copyright
 * 
 *  Interface representation of capital cost allowance classes handling
 *  asset pools.
 *  Copyright (C) 2021  DZ-FSDev
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
package com.dz_fs_dev.finance.canadaRevenueAgency.capitalAssets;

import java.util.Date;

/**
 * The user of this interface should implement a representation of capital cost
 * allowance classes in accordance to to guidance provided by tax authorities
 * on handling of asset pools.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 * @see https://www.canada.ca/en/revenue-agency/services/tax/businesses/topics/sole-proprietorships-partnerships/report-business-income-expenses/claiming-capital-cost-allowance/classes.html
 */
public interface ICapitalCostAllowance {
	/**
	 * Returns true if an asset pool is eligible for consideration under this
	 * capital cost allowance classification; false otherwise.
	 * 
	 * @param assetPool The specified asset pool to be considered.
	 * @return True if an asset pool is eligible for consideration under this
	 * 			capital cost allowance classification; false otherwise.
	 * @since 0.0.2
	 */
	public boolean isEligible(IAssetPool assetPool);
	
	/**
	 * Returns true if an asset pool is eligible for consideration under this
	 * capital cost allowance classification by date; false otherwise.
	 * 
	 * @param acquistionDate The specified date of acquisition for the capital
	 *        asset.
	 * @param filingDate The specified date of tax filing for the capital asset.
	 * @return True if an asset pool is eligible for consideration under this
	 * 			capital cost allowance classification; false otherwise.
	 * @since 0.0.2
	 */
	public boolean isEligibleByDate(Date acquistionDate, Date filingDate);
}
