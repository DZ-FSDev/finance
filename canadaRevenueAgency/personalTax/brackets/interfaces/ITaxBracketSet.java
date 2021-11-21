package com.dz_fs_dev.finance.canadaRevenueAgency.interfaces.personalTax.brackets;

import java.math.BigDecimal;

/**
 * The user of this interface should implement an internal set of Tax Brackets
 * and associated tax-related methods. 
 * 
 * @author DZ_FSDev
 * @since 16.0.1
 * @version 0.0.2
 */
public interface ITaxBracketSet{
	/**
	 * Calculates the applicable taxes given an income for this set of Tax
	 * Brackets.
	 * 
	 * @param income The income of to be taxed.
	 * @return The applicable taxes given an income for this set of Tax
	 *         Brackets.
	 */
	public BigDecimal calculateTax(BigDecimal income);
	
	/**
	 * Calculates the effective tax rate given an income for this set of Tax
	 * Brackets.
	 * 
	 * @param income The income to be taxed.
	 * @param precision The precision of the effective tax rate to be returned.
	 * @return The effective tax rate given an income for this set of Tax
	 *         Brackets.
	 */
	public BigDecimal calculateEffectiveTaxRate(BigDecimal income,
			int precision);
	
	/**
	 * Calculates the effective tax rate given an income for this set of Tax
	 * Brackets and compares it to the effective tax rate for the same income
	 * in another TaxBracket set.
	 * 
	 * @param income The income to be taxed.
	 * @param precision The precision of the effective tax rate to be returned.
	 * @return The difference in the effective tax rate given an income.
	 */
	public BigDecimal compareEffectiveTaxRate(BigDecimal income, 
			ITaxBracketSet otherTaxBracket);
}
