/*  Original Licensing Copyright
 * 
 *  Set of Tax Brackets and associated tax-related methods. 
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
package com.dz_fs_dev.finance.canadaRevenueAgency.interfaces.personalTax.brackets;

import java.math.BigDecimal;

/**
 * The user of this interface should implement an internal set of Tax Brackets
 * and associated tax-related methods. 
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3
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
	 * @param otherTaxBracket The specified tax bracket for comparison.
	 * @return The difference in the effective tax rate given an income.
	 */
	public BigDecimal compareEffectiveTaxRate(BigDecimal income, 
			int precision, ITaxBracketSet otherTaxBracket);
}
