package com.dz_fs_dev.finance.spotMarkets.domain;

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
 * Domain Object representing an Order placed in a spot market.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 15.0.0.2
 */
@Entity
public class SpotOrder implements Serializable{
	private static final long serialVersionUID = -786004822888844302L;
	
	public static enum OrderSide {LIMIT_BID, LIMIT_ASK, MARKET_BID, MARKET_ASK};
	public static enum OrderStatus {NEW, ACTIVE, NSF, PARTIAL_FILL, FILLED, CANCELED, PARTIAL_CANCEL};
	
	private @Getter @Setter @GeneratedValue @Id long orderId;
	
	private @Getter @Setter BigInteger amount;
	private @Getter @Setter BigInteger executedAmount;
	
	private @Getter @Setter BigDecimal quote;
	private @Getter @Setter @Enumerated(EnumType.ORDINAL) @Column(nullable = false, updatable = false) OrderSide orderSide;
	private @Getter @Setter @Enumerated(EnumType.ORDINAL) @Column(nullable = false) OrderStatus orderStatus;
	
	private @Getter @Setter @ManyToOne(fetch=FetchType.LAZY) SpotAsset asset;
	
	/**
	 * Default zero-arg constructor for SpotOrder.
	 */
	public SpotOrder() {}

	@Override
	public int hashCode() {
		final int prime = 1476204733;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result + ((executedAmount == null) ? 0 : executedAmount.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((orderSide == null) ? 0 : orderSide.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((quote == null) ? 0 : quote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotOrder))
			return false;
		SpotOrder other = (SpotOrder) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		if (executedAmount == null) {
			if (other.executedAmount != null)
				return false;
		} else if (!executedAmount.equals(other.executedAmount))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderSide != other.orderSide)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (quote == null) {
			if (other.quote != null)
				return false;
		} else if (!quote.equals(other.quote))
			return false;
		return true;
	}
}
