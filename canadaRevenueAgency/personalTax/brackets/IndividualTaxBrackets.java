package com.dz_fs_dev.finance.canadaRevenueAgency.personalTax.brackets;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.dz_fs_dev.finance.canadaRevenueAgency.interfaces.personalTax.brackets.ITaxBracketSet;

/**
 * Represents historical income tax brackets for individuals in Canada for the Provinces. Rates are
 * laid out by the <a href="https://www.canada.ca/en/revenue-agency.html">Canada Revenue Agency</a>
 * and updated annually.
 * <p>The following tax years are supported:
 * <ul>
 * 	<li>2021</li>
 * </ul>
 * <p>The following tax brackets are supported:
 * <ul>
 * 	<li>Federal</li>
 * 	<li>Provincial</li>
 * 	<ul>
 * 		<li>Newfoundland and Labrador</li>
 * 		<li>Prince Edward Island</li>
 * 		<li>Nova Scotia</li>
 * 		<li>New Brunswick</li>
 * 		<li>Ontario</li>
 * 		<li>Manitoba</li>
 * 	</ul>
 * </ul>
 * 
 * @see <a href="https://laws-lois.justice.gc.ca/eng/acts/I-3.3/index.html">
 *  	Income Tax Act (R.S.C., 1985, c.1 (5th Supp.))</a>.
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.5
 */
public enum IndividualTaxBrackets implements ITaxBracketSet{
	/** Canadian Federal Income Tax Rates: 2021 */
	FEDERAL2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.15"), BigDecimal.ZERO, new BigDecimal(49020)),
			new TaxBracket(new BigDecimal("0.205"), new BigDecimal(49020), new BigDecimal(98040)),
			new TaxBracket(new BigDecimal("0.26"), new BigDecimal(98040), new BigDecimal(151978)),
			new TaxBracket(new BigDecimal("0.29"), new BigDecimal(151978), new BigDecimal(216511)),
			new TaxBracket(new BigDecimal("0.33"), new BigDecimal(216511), null)
	}),
	
	/** Newfoundland and Labrador Provincial Income Tax Rates: 2021 */
	NL2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.087"), BigDecimal.ZERO, new BigDecimal(38081)),
			new TaxBracket(new BigDecimal("0.145"), new BigDecimal(38081), new BigDecimal(76161)),
			new TaxBracket(new BigDecimal("0.158"), new BigDecimal(76161), new BigDecimal(135973)),
			new TaxBracket(new BigDecimal("0.173"), new BigDecimal(151978), new BigDecimal(190363)),
			new TaxBracket(new BigDecimal("0.183"), new BigDecimal(190363), null)
	}),
	
	/** Prince Edward Island Provincial Income Tax Rates: 2021 */
	PE2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.098"), BigDecimal.ZERO, new BigDecimal(31984)),
			new TaxBracket(new BigDecimal("0.138"), new BigDecimal(38081), new BigDecimal(63969)),
			new TaxBracket(new BigDecimal("0.167"), new BigDecimal(63969), null)
	}),
	
	/** Nova Scotia Provincial Income Tax Rates: 2021 */
	NS2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.0879"), BigDecimal.ZERO, new BigDecimal(29590)),
			new TaxBracket(new BigDecimal("0.1495"), new BigDecimal(29590), new BigDecimal(59180)),
			new TaxBracket(new BigDecimal("0.1667"), new BigDecimal(59180), new BigDecimal(93000)),
			new TaxBracket(new BigDecimal("0.175"), new BigDecimal(93000), new BigDecimal(150000)),
			new TaxBracket(new BigDecimal("0.21"), new BigDecimal(150000), null)
	}),
	
	/** New Brunswick Provincial Income Tax Rates: 2021 */
	NB2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.0968"), BigDecimal.ZERO, new BigDecimal(43835)),
			new TaxBracket(new BigDecimal("0.1482"), new BigDecimal(43835), new BigDecimal(87670)),
			new TaxBracket(new BigDecimal("0.1652"), new BigDecimal(87670), new BigDecimal(142533)),
			new TaxBracket(new BigDecimal("0.1784"), new BigDecimal(142533), new BigDecimal(162383)),
			new TaxBracket(new BigDecimal("0.203"), new BigDecimal(162383), null)
	}),
	
	/** Ontario Provincial Income Tax Rates: 2021 */
	ON2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.0505"), BigDecimal.ZERO, new BigDecimal(45142)),
			new TaxBracket(new BigDecimal("0.0915"), new BigDecimal(45142), new BigDecimal(90287)),
			new TaxBracket(new BigDecimal("0.1116"), new BigDecimal(90287), new BigDecimal(150000)),
			new TaxBracket(new BigDecimal("0.1216"), new BigDecimal(150000), new BigDecimal(220000)),
			new TaxBracket(new BigDecimal("0.1316"), new BigDecimal(220000), null)
	}),
	
	/** Manitoba Provincial Income Tax Rates: 2021 */
	MB2021(new TaxBracket[] {
			new TaxBracket(new BigDecimal("0.108"), BigDecimal.ZERO, new BigDecimal(33723)),
			new TaxBracket(new BigDecimal("0.1275"), new BigDecimal(33723), new BigDecimal(72885)),
			new TaxBracket(new BigDecimal("0.174"), new BigDecimal(72885), null)
	});
	
	private final List<TaxBracket> TAX_BRACKETS;
	
	/**
	 * Initializes a new set of Tax Brackets.
	 * 
	 * @param taxBrackets The set of tax brackets.
	 */
	private IndividualTaxBrackets(TaxBracket[] taxBrackets) {
		this.TAX_BRACKETS = Collections.unmodifiableList(Arrays.asList(taxBrackets));
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public BigDecimal calculateTax(BigDecimal income) {
		BigDecimal applicableTaxes = BigDecimal.ZERO;
		
		for(TaxBracket t : TAX_BRACKETS) {
			income = income.subtract(t.getMAX_BRACKET_INCOME());
			
			BigDecimal taxableIncome = income.min(t.getBRACKET_INCOME_RANGE());
			if(taxableIncome.compareTo(BigDecimal.ZERO) < 0)break;
			applicableTaxes = applicableTaxes.add(taxableIncome.multiply(t.getTAX_RATE()));
		}
		
		return applicableTaxes;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public BigDecimal calculateEffectiveTaxRate(BigDecimal income, int precision) {
		// TODO
		return null;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public BigDecimal compareEffectiveTaxRate(BigDecimal income, ITaxBracketSet otherTaxBracket) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns a link String representation of this set of tax brackets. 
	 * 
	 * @return 
	 * @since 0.0.2
	 */
	@Override
	public String toString() {
		//TODO
		return null;
	}
}
