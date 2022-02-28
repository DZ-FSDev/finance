package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount.Account;
import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a liquid pool position.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.7
 */
@Entity
public class Position implements Serializable{
	/**
	 * @since 0.0.7
	 */
	private static final long serialVersionUID = 7946385449636885730L;

	private @Getter @Setter @GeneratedValue @Id Long positionId;

	private @Getter @Setter @JsonIgnore @ManyToOne(fetch = FetchType.LAZY, optional = false) Account account;

	private @Getter @Setter BigInteger cumulativeUnits;
	private @Getter @Setter BigInteger units;

	private @Getter @Setter BigInteger costBasis;
	private @Getter @Setter @Transient BigDecimal unrealizedPNL;
	private @Getter @Setter BigDecimal realizedPNL;
	private @Getter @Setter @ManyToOne(optional = false) Asset basisCurrency;

	/**
	 * {@inheritDoc}
	 * <p>Ignores transient fields.</p>
	 * @since 0.0.7
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((basisCurrency == null) ? 0 : basisCurrency.hashCode());
		result = prime * result + ((costBasis == null) ? 0 : costBasis.hashCode());
		result = prime * result + ((positionId == null) ? 0 : positionId.hashCode());
		result = prime * result + ((realizedPNL == null) ? 0 : realizedPNL.hashCode());
		result = prime * result + ((cumulativeUnits == null) ? 0 : cumulativeUnits.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * <p>Ignores transient fields.</p>
	 * @since 0.0.7
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
		if (basisCurrency == null) {
			if (other.basisCurrency != null)
				return false;
		} else if (!basisCurrency.equals(other.basisCurrency))
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
		if (realizedPNL == null) {
			if (other.realizedPNL != null)
				return false;
		} else if (!realizedPNL.equals(other.realizedPNL))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		if (cumulativeUnits == null) {
			if (other.cumulativeUnits != null)
				return false;
		} else if (!cumulativeUnits.equals(other.cumulativeUnits))
			return false;
		return true;
	}

	/**
	 * @since 0.0.7
	 */
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", account=" + account + ", units=" + units + ", cumulativeUnits=" + cumulativeUnits + ", costBasis="
				+ costBasis + ", unrealizedPNL=" + unrealizedPNL + ", realizedPNL=" + realizedPNL + ", basisCurrency="
				+ basisCurrency + "]";
	}
}
