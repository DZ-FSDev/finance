package com.dz_fs_dev.finance.canadaRevenueAgency.corporateTax.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing a general ledger transaction.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 16.0.1
 */
@Entity
public class PostedTransaction implements Serializable{
	/**
	 * @since 0.0.2
	 */
	private static final long serialVersionUID = 463884618144843225L;
	
	private @Getter @Setter @GeneratedValue @Id long transactionId;
	private @Getter @Setter String description;
	
	@ElementCollection(targetClass = Entry.class, fetch = FetchType.LAZY)
	private @Getter @Setter @Column(nullable = false, updatable = false, unique = true) Set<Entry> entries;

	/**
	 * Default constructor for PostedTransaction.
	 */
	public PostedTransaction() {}

	/**
	 * @since 0.0.2
	 */
	@Override
	public int hashCode() {
		final int prime = 777373;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		return result;
	}

	/**
	 * @since 0.0.2
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PostedTransaction))
			return false;
		PostedTransaction other = (PostedTransaction) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
}
