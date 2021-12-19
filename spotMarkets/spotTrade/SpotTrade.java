package com.dz_fs_dev.finance.spotMarkets.spotTrade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing a Trade placed in a spot market.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@Entity
public class SpotTrade implements Serializable{
	/**
	 * @since 0.0.2
	 */
	private static final long serialVersionUID = 445646877170585832L;

	private @Getter @Setter @GeneratedValue @Id Long tradeId;
	
	private @Getter @Setter SpotOrder maker;
	private @Getter @Setter SpotOrder taker;
	
	private @Getter @Setter BigDecimal transactedAssetVolume;
	private @Getter @Setter CommissionFee commissionFee;
	
	private @Getter @Setter long transactTime;
	
	/**
	 * Default constructor for SpotTrade.
	 */
	public SpotTrade() {}

	@Override
	public int hashCode() {
		final int prime = 983;
		int result = 1;
		result = prime * result + ((commissionFee == null) ? 0 : commissionFee.hashCode());
		result = prime * result + ((maker == null) ? 0 : maker.hashCode());
		result = prime * result + ((taker == null) ? 0 : taker.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + (int) (transactTime ^ (transactTime >>> 32));
		result = prime * result + ((transactedAssetVolume == null) ? 0 : transactedAssetVolume.hashCode());
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
		if (transactedAssetVolume == null) {
			if (other.transactedAssetVolume != null)
				return false;
		} else if (!transactedAssetVolume.equals(other.transactedAssetVolume))
			return false;
		return true;
	}
}
