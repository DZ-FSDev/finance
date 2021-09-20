package com.dz_fs_dev.finance.canadaRevenueAgency.personalTax.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object for capital assets. Supports 8 decimal half-up precision.
 * 
 * @author DZ-FSDev
 * @since 16
 * @version 0.0.1
 */
@Entity
public class CapitalAsset implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 2425958119510149071L;

	private @Getter @Setter @Id @GeneratedValue long capitalAssetID;
	
	private @Transient @Setter BigDecimal units;
	private @Transient @Setter BigDecimal ACB;
	
	@ElementCollection(targetClass=PNL.class)
	private @Transient @Setter List<PNL> realizedProfitLoss;
	
	@ElementCollection(targetClass=PNL.class)
	private @Transient @Setter List<PNL> realizedCapitalGains;
	
	@ElementCollection(targetClass=CapitalAssetTransaction.class)
	private @Getter @Setter @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<CapitalAssetTransaction> transactions;
	
	public BigDecimal getUnits() {
		if(units == null)parseTransactions();
		return this.units;
	}
	
	public BigDecimal getACB() {
		if(units == null)parseTransactions();
		return this.ACB;
	}

	/**
	 * Iterates over transactions performed relating to the Capital Asset to calculate the units, ACB and yearly PNL up to date.
	 */
	private void parseTransactions() {
		for(CapitalAssetTransaction tx : transactions) {
			//TODO
		}
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ACB == null) ? 0 : ACB.hashCode());
		result = prime * result + (int) (capitalAssetID ^ (capitalAssetID >>> 32));
		result = prime * result + ((realizedCapitalGains == null) ? 0 : realizedCapitalGains.hashCode());
		result = prime * result + ((realizedProfitLoss == null) ? 0 : realizedProfitLoss.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CapitalAsset))
			return false;
		CapitalAsset other = (CapitalAsset) obj;
		if (ACB == null) {
			if (other.ACB != null)
				return false;
		} else if (!ACB.equals(other.ACB))
			return false;
		if (capitalAssetID != other.capitalAssetID)
			return false;
		if (realizedCapitalGains == null) {
			if (other.realizedCapitalGains != null)
				return false;
		} else if (!realizedCapitalGains.equals(other.realizedCapitalGains))
			return false;
		if (realizedProfitLoss == null) {
			if (other.realizedProfitLoss != null)
				return false;
		} else if (!realizedProfitLoss.equals(other.realizedProfitLoss))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}
}
