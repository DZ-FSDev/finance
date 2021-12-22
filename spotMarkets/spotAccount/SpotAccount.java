package com.dz_fs_dev.finance.spotMarkets.spotAccount;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dz_fs_dev.finance.markets.interfaces.Account;
import com.dz_fs_dev.finance.spotMarkets.spotPosition.SpotPosition;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing an Account in spot markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
@Entity
public class SpotAccount implements Serializable, Account{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -2480756664415763406L;

	private @Getter @Setter @Id @GeneratedValue Long AccountId;
	
	private @Getter @Setter @Column(nullable = false, unique = true) String username;
	private @Getter @Setter @Column(nullable = true) String nickname;
	
	private @Getter @Setter @ElementCollection Set<SpotPosition> positions;

	/**
	 * Default constructor for SpotAccount.
	 */
	public SpotAccount() {}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 48491;
		int result = 1;
		result = prime * result + ((AccountId == null) ? 0 : AccountId.hashCode());
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotAccount))
			return false;
		SpotAccount other = (SpotAccount) obj;
		if (AccountId == null) {
			if (other.AccountId != null)
				return false;
		} else if (!AccountId.equals(other.AccountId))
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
			return false;
		return true;
	}
}
