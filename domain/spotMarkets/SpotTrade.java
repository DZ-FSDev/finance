package com.dz_fs_dev.finance.domain.spotMarkets;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing a Trade placed in a spot market.
 * @version 0.1
 * @since 15
 * @author dz_fs_dev
 *
 */

@Entity
public class SpotTrade implements Serializable{
	private static final long serialVersionUID = 3788156901020584232L;
	
	private @Getter @Setter @GeneratedValue @Id Long tradeId;
	
	private @Getter @Setter SpotOrder maker;
	private @Getter @Setter SpotOrder taker;
	
	private @Getter @Setter BigInteger transactedAssets;
	private @Getter @Setter CommissionFee commissionFee;
	
	private @Getter @Setter long transactTime;

	@Override
	public int hashCode() {
		final int prime = 983;
		int result = 1;
		result = prime * result + ((commissionFee == null) ? 0 : commissionFee.hashCode());
		result = prime * result + ((maker == null) ? 0 : maker.hashCode());
		result = prime * result + ((taker == null) ? 0 : taker.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + (int) (transactTime ^ (transactTime >>> 32));
		result = prime * result + ((transactedAssets == null) ? 0 : transactedAssets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotTrade))
			return false;
		SpotTrade other = (SpotTrade) obj;
		if (commissionFee == null) {
			if (other.commissionFee != null)
				return false;
		} else if (!commissionFee.equals(other.commissionFee))
			return false;
		if (maker == null) {
			if (other.maker != null)
				return false;
		} else if (!maker.equals(other.maker))
			return false;
		if (taker == null) {
			if (other.taker != null)
				return false;
		} else if (!taker.equals(other.taker))
			return false;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (transactTime != other.transactTime)
			return false;
		if (transactedAssets == null) {
			if (other.transactedAssets != null)
				return false;
		} else if (!transactedAssets.equals(other.transactedAssets))
			return false;
		return true;
	}
	
	
}
