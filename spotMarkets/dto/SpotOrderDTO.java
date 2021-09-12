package com.dz_fs_dev.finance.spotMarkets.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.dz_fs_dev.finance.spotMarkets.domain.SpotAsset;
import com.dz_fs_dev.finance.spotMarkets.domain.SpotOrder.OrderSide;
import com.dz_fs_dev.finance.spotMarkets.domain.SpotOrder.OrderStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object representing an Order placed in a spot market for read-only operations.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 15.0.0.2
 */
public class SpotOrderDTO{
	private @Getter @Setter long orderId;
	
	private @Getter @Setter BigInteger amount;
	private @Getter @Setter BigInteger executedAmount;
	
	private @Getter @Setter BigDecimal quote;
	private @Getter @Setter OrderSide orderSide;
	private @Getter @Setter OrderStatus orderStatus;
	
	private @Getter @Setter SpotAsset asset;
	
	private @Getter final long creationTime;

	/**
	 * Constructs the SpotOrderDTO.
	 * 
	 * @param orderId The orderID referenced by the exchange.
	 * @param amount The original order quantity.
	 * @param executedAmount The number of units of the order already executed.
	 * @param quote The preferred price of order execution for limit orders. Ignored for market orders.
	 * @param orderSide Whether the order is a bid or ask.
	 * @param orderStatus The current status of the order since DTO creation.
	 * @param asset The asset the order deals with.
	 */
	public SpotOrderDTO(long orderId, BigInteger amount, BigInteger executedAmount, BigDecimal quote,
			OrderSide orderSide, OrderStatus orderStatus, SpotAsset asset, long creationTime) {
		this.creationTime = creationTime;
		this.orderId = orderId;
		this.amount = amount;
		this.executedAmount = executedAmount;
		this.quote = quote;
		this.orderSide = orderSide;
		this.orderStatus = orderStatus;
		this.asset = asset;
	}

	@Override
	public int hashCode() {
		final int prime = 58613;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result + (int) (creationTime ^ (creationTime >>> 32));
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
		if (!(obj instanceof SpotOrderDTO))
			return false;
		SpotOrderDTO other = (SpotOrderDTO) obj;
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
		if (creationTime != other.creationTime)
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
