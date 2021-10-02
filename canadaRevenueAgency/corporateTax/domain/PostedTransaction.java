package com.dz_fs_dev.finance.canadaRevenueAgency.corporateTax.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

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
public class PostedTransaction implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 9201330493544309858L;
	
	@ElementCollection(targetClass = Entry.class)
	private @Getter @Setter Set<Entry> entries;

	/**
	 * Default constructor for PostedTransaction.
	 */
	public PostedTransaction() {}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 777373;
		int result = 1;
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PostedTransaction))
			return false;
		PostedTransaction other = (PostedTransaction) obj;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
			return false;
		return true;
	}
}
