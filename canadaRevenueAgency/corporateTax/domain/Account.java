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
 * @version 0.0.1
 * @since 16.0.1
 */
@Entity
public class Account implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 6457503294247610984L;

	public static enum AccountType {ASSET, LIABILITY, SHARE_EQUITY};
	
	
	private @Getter @Setter @GeneratedValue @Id long accountId;
	private @Getter @Setter @Column(nullable = false, updatable = false) String name;
	private @Getter @Setter @Enumerated(EnumType.ORDINAL) @Column(nullable = false, updatable = false) AccountType accountType;
	
	@ElementCollection(targetClass=PostedTransaction.class)
	private @Getter @Setter @ManyToMany() List<PostedTransaction> posts;
	
	/**
	 * Default constructor for Account.
	 */
	public Account() {}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
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
