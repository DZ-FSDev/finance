package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount.Account;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a liquid pool position.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@Entity
public class Position implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -1046468471511570027L;
	
	private @Getter @Setter @GeneratedValue @Id Long positionId;
	
	private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY, optional = false) Account account;
	
	private @Getter @Setter BigDecimal costBasis;

	/**
	 * @since 0.0.2
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((costBasis == null) ? 0 : costBasis.hashCode());
		result = prime * result + ((positionId == null) ? 0 : positionId.hashCode());
		return result;
	}

	/**
	 * @since 0.0.2
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (costBasis == null) {
			if (other.costBasis != null)
				return false;
		} else if (!costBasis.equals(other.costBasis))
			return false;
		if (positionId == null) {
			if (other.positionId != null)
				return false;
		} else if (!positionId.equals(other.positionId))
			return false;
		return true;
	}

	/**
	 * @since 0.0.2
	 */
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", account=" + account + ", costBasis=" + costBasis + "]";
	}
}
