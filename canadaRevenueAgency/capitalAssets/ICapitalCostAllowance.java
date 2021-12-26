package com.dz_fs_dev.finance.canadaRevenueAgency.capitalAssets;

import java.util.Date;

/**
 * The user of this interface should implement a representation of capital cost
 * allowance classes in accordance to to guidance provided by tax authorities
 * on handling of asset pools.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 * @see https://www.canada.ca/en/revenue-agency/services/tax/businesses/topics/sole-proprietorships-partnerships/report-business-income-expenses/claiming-capital-cost-allowance/classes.html
 */
public interface ICapitalCostAllowance {
	/**
	 * Returns true if an asset pool is eligible for consideration under this
	 * capital cost allowance classification; false otherwise.
	 * 
	 * @param acquistionDate
	 * @param filingDate
	 * @return True if an asset pool is eligible for consideration under this
	 * 			capital cost allowance classification; false otherwise.
	 * @since 0.0.1
	 */
	public boolean isEligible(Date acquistionDate, Date filingDate);
}
