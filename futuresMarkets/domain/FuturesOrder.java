package com.dz_fs_dev.finance.futuresMarkets.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing an Order placed in a futures market.
 * 
 * @version 0.0.1
 * @author DZ-FSDev
 * @since 16
 */
@Entity
public class FuturesOrder implements Serializable{
	private static final long serialVersionUID = -8994718820789379908L;
	
	private @Getter @Setter @GeneratedValue @Id long orderId;
	
	public static enum OrderSide {LIMIT_SHORT, LIMIT_LONG, MARKET_SHORT, MARKET_LONG};
	public static enum OrderStatus {NEW, ACTIVE, NSF, PARTIAL_FILL, FILLED, CANCELED, PARTIAL_CANCEL};
	
	private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY, optional = false) FuturesAsset asset;
	
	private @Getter @Setter BigInteger contracts;
	private @Getter @Setter BigInteger executedContracts;
	
	private @Getter @Setter BigDecimal strikePrice;
	private @Getter @Setter BigDecimal premium;
	
	private @Getter @Setter @Enumerated(EnumType.ORDINAL) @Column(nullable = false, updatable = false) OrderSide orderSide;
	private @Getter @Setter @Enumerated(EnumType.ORDINAL) @Column(nullable = false) OrderStatus orderStatus;
	
	private @Getter @Setter long expiry;
	
	/**
	 * Default constructor for Futures Order.
	 */
	public FuturesOrder() {}

	@Override
	public int hashCode() {
		final int prime = 737411;
		int result = 1;
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result + ((contracts == null) ? 0 : contracts.hashCode());
		result = prime * result + ((executedContracts == null) ? 0 : executedContracts.hashCode());
		result = prime * result + (int) (expiry ^ (expiry >>> 32));
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((orderSide == null) ? 0 : orderSide.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((premium == null) ? 0 : premium.hashCode());
		result = prime * result + ((strikePrice == null) ? 0 : strikePrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FuturesOrder))
			return false;
		FuturesOrder other = (FuturesOrder) obj;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		if (contracts == null) {
			if (other.contracts != null)
				return false;
		} else if (!contracts.equals(other.contracts))
			return false;
		if (executedContracts == null) {
			if (other.executedContracts != null)
				return false;
		} else if (!executedContracts.equals(other.executedContracts))
			return false;
		if (expiry != other.expiry)
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderSide != other.orderSide)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (premium == null) {
			if (other.premium != null)
				return false;
		} else if (!premium.equals(other.premium))
			return false;
		if (strikePrice == null) {
			if (other.strikePrice != null)
				return false;
		} else if (!strikePrice.equals(other.strikePrice))
			return false;
		return true;
	}
}
