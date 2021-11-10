package com.dz_fs_dev.finance.canadaRevenueAgency.personalTax.brackets.interfaces;

import java.math.BigDecimal;

/**
 * The user of this interface should implement an internal set of Tax Brackets
 * and associated tax-related methods. 
 * 
 * @author DZ_FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public interface TaxBracketSet{
	/**
	 * Calculates the applicable taxes given an income for this set of Tax Brackets.
	 * 
	 * @param income The income of to be taxed.
	 * @return The applicable taxes given an income for this set of Tax Brackets.
	 */
	public BigDecimal calculateTax(BigDecimal income);
	
	/**
	 * Calculates the effective tax rate given an income for this set of Tax Brackets.
	 * 
	 * @param income The income to be taxed.
	 * @return The effective tax rate given an income for this set of Tax Brackets.
	 */
	public BigDecimal calculateEffectiveTaxRate(BigDecimal income);
}
