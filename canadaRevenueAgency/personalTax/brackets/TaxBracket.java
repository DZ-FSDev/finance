package com.dz_fs_dev.finance.canadaRevenueAgency.personalTax.brackets;

import java.math.BigDecimal;

/**
 * Represents an income tax bracket. Supports a fixed rate for a range of incomes.
 * 
 * @author DZ_FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class TaxBracket {
	private final BigDecimal TAX_RATE;
	private final BigDecimal MIN_BRACKET_INCOME;
	private final BigDecimal MAX_BRACKET_INCOME;
	private final BigDecimal BRACKET_INCOME_RANGE;
	
	/**
	 * Initializes a Tax Bracket with a tax rate and a range of incomes for application.
	 * 
	 * @param taxRate The income tax rate.
	 * @param minBracketIncome The minimum income required to begin the application of this tax rate.
	 * @param maxBracketIncome The minimum income that will receive application of this tax rate.
	 */
	public TaxBracket(BigDecimal taxRate, BigDecimal minBracketIncome, BigDecimal maxBracketIncome) {
		this.TAX_RATE = taxRate;
		this.MIN_BRACKET_INCOME = minBracketIncome;
		this.MAX_BRACKET_INCOME = maxBracketIncome;
		this.BRACKET_INCOME_RANGE = this.MAX_BRACKET_INCOME.subtract(this.MIN_BRACKET_INCOME);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MAX_BRACKET_INCOME == null) ? 0 : MAX_BRACKET_INCOME.hashCode());
		result = prime * result + ((MIN_BRACKET_INCOME == null) ? 0 : MIN_BRACKET_INCOME.hashCode());
		result = prime * result + ((TAX_RATE == null) ? 0 : TAX_RATE.hashCode());
		return result;
	}

	/**
	 * @return The Tax Rate for this bracket.
	 */
	public BigDecimal getTAX_RATE() {
		return TAX_RATE;
	}

	/**
	 * @return The range between the boundaries of incomes to be taxed.
	 */
	public BigDecimal getBRACKET_INCOME_RANGE() {
		return BRACKET_INCOME_RANGE;
	}

	/**
	 * @return The lower boundary of income to be taxed.
	 */
	public BigDecimal getMIN_BRACKET_INCOME() {
		return MIN_BRACKET_INCOME;
	}

	/**
	 * @return The upper boundary of income to be taxed.
	 */
	public BigDecimal getMAX_BRACKET_INCOME() {
		return MAX_BRACKET_INCOME;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TaxBracket))
			return false;
		TaxBracket other = (TaxBracket) obj;
		if (MAX_BRACKET_INCOME == null) {
			if (other.MAX_BRACKET_INCOME != null)
				return false;
		} else if (!MAX_BRACKET_INCOME.equals(other.MAX_BRACKET_INCOME))
			return false;
		if (MIN_BRACKET_INCOME == null) {
			if (other.MIN_BRACKET_INCOME != null)
				return false;
		} else if (!MIN_BRACKET_INCOME.equals(other.MIN_BRACKET_INCOME))
			return false;
		if (TAX_RATE == null) {
			if (other.TAX_RATE != null)
				return false;
		} else if (!TAX_RATE.equals(other.TAX_RATE))
			return false;
		return true;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public String toString() {
		return "TaxBracket [TAX_RATE=" + TAX_RATE + ", MIN_BRACKET_INCOME=" + MIN_BRACKET_INCOME
				+ ", MAX_BRACKET_INCOME=" + MAX_BRACKET_INCOME + ", BRACKET_INCOME_RANGE=" + BRACKET_INCOME_RANGE + "]";
	}
}
