package com.dz_fs_dev.finance.canadaRevenueAgency.corporateTax.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing a balance sheet account.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 16.0.1
 */
@Entity
public class Account implements Serializable{
	/**
	 * @since 0.0.2
	 */
	private static final long serialVersionUID = 2757503295247617984L;

	public static enum AccountType {
		ASSET_MISC, 
		ASSET_ACCOUNTS_RECIEVABLE,
		ASSET_NOTES_RECIEVABLE,
		ASSET_INTEREST_RECIEVABLE,
		ASSET_SECURITY_DEPOSITS_PAID,
		ASSET_PROPERTY,
		ASSET_PLANT,
		ASSET_EQUIPMENT,
		ASSET_CASH,
		ASSET_LAND,
		ASSET_VEHICLES,
		ASSET_INVENTORY,
		ASSET_PREPAID_RENT,
		ASSET_PREPAID_INSURANCE,
		ASSET_PREPAID_PRIOPERTY_TAX,
		ASSET_PREPAID_LICENSE,
		ASSET_SUPPLIES,
		ASSET_EMPLOYEE_ADVANCES,
		ASSET_INVESTMENTS_GIC,
		ASSET_INVESTMENTS_SHORTS,
		ASSET_INVESTMENTS_LONGS,
		ASSET_INVESTMENTS_CRYPTOCURRENCY,
		
		CONTRA_ASSET_ACCUMULATED_DEPRECIATION_PROPERTY,
		CONTRA_ASSET_ACCUMULATED_DEPRECIATION_PLANT,
		CONTRA_ASSET_ACCUMULATED_DEPRECIATION_EQUIPMENT,
		CONTRA_ASSET_ACCUMULATED_DEPRECIATION_VEHICLES,
		
		LIABILITY_MISC, 
		LIABILITY_ACCOUNTS_PAYABLE,
		LIABILITY_SECURITY_DEPOSITS_RECIEVED,
		LIABILITY_NOTES_PAYABLE,
		LIABILITY_INTEREST_PAYABLE,
		LIABILITY_INCOME_TAX_PAYABLE,
		LIABILITY_BANK_LOAN_PAYABLE,
		LIABILITY_MORTGAGE_PAYABLE,
		LIABILITY_WAGES_PAYABLE,
		LIABILITY_DIVIDENDS_PAYABLE,
		LIABILITY_UNEARNED_REVENUE_GOODS,
		LIABILITY_UNEARNED_REVENUE_SERVICES,
		LIABILITY_UNEARNED_REVENUE_MISC,
		
		SHARE_EQUITY_MISC,
		SHARE_EQUITY_MISC_EXPENSE,
		SHARE_EQUITY_MISC_REVENUE,
		SHARE_EQUITY_COMMON_SHARES_A,
		SHARE_EQUITY_COMMON_SHARES_B,
		SHARE_EQUITY_COMMON_SHARES_C,
		SHARE_EQUITY_COMMON_SHARES_D,
		SHARE_EQUITY_COMMON_SHARES_E,
		SHARE_EQUITY_COST_OF_GOODS_SOLD,
		SHARE_EQUITY_INTEREST_EXPENSE,
		SHARE_EQUITY_INTEREST_REVENUE,
		SHARE_EQUITY_ADVERTISING_EXPENSE,
		SHARE_EQUITY_DEPRECIATION_EXPENSE,
		SHARE_EQUITY_SELLING_EXPENSE,
		SHARE_EQUITY_ADMIN_EXPENSE,
		SHARE_EQUITY_SUPPLIES_EXPENSE,
		SHARE_EQUITY_SOFTWARE_LICENSE_EXPENSE,
		SHARE_EQUITY_HARDWARE_LICENSE_EXPENSE,
		SHARE_EQUITY_INSURANCE_EXPENSE,
		SHARE_EQUITY_INCOME_TAX_EXPENSE,
		SHARE_EQUITY_WAGES_EXPENSE,
		SHARE_EQUITY_DIVIDENDS_DECLARED,
		SHARE_EQUITY_DIVIDENDS_EXPENSE,
		SHARE_EQUITY_DIVIDENDS_REVENUE,
		SHARE_EQUITY_PROPERTY_TAX_EXPENSE,
		SHARE_EQUITY_UTILITIES_EXPENSE,
		SHARE_EQUITY_RENT_EXPENSE,
		SHARE_EQUITY_RENT_REVENUE,
		SHARE_EQUITY_TELECOM_EXPENSE,
		SHARE_EQUITY_TELECOM_REVENUE,
		SHARE_EQUITY_SERVICE_REVENUE,
		SHARE_EQUITY_SALES_REVENUE,
		SHARE_EQUITY_SPOILAGE_EXPENSE,
		SHARE_EQUITY_OPERATING_EXPENSE,
		SHARE_EQUITY_REPAIRS_EXPENSE
	};
	
	private @Getter @Setter @GeneratedValue @Id long accountId;
	private @Getter @Setter @Column(nullable = false, updatable = false) String name;
	private @Getter @Setter @Enumerated(EnumType.STRING) @Column(nullable = false, updatable = false) AccountType accountType;
	
	@ElementCollection(targetClass=PostedTransaction.class)
	private @Getter @Setter @ManyToMany() List<PostedTransaction> posts;
	
	/**
	 * Default constructor for Account.
	 */
	public Account() {}

	/**
	 * @since 0.0.2
	 */
	@Override
	public int hashCode() {
		final int prime = 15371;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		return result;
	}

	/**
	 * @since 0.0.2
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType != other.accountType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		return true;
	}
}
