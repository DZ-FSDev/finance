package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket.Market;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a candlestick in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@Entity
public class Candlestick implements Serializable{
	/**
	 * @since 0.0.2
	 */
	private static final long serialVersionUID = 4803287014577636182L;

	private @Getter @Setter @Id @GeneratedValue Long candlestickId;
	
	private @Getter @Setter Long openTimestamp;
	private @Getter @Setter Long closeTimestamp;
	
	private @Getter @Setter BigDecimal open;
	private @Getter @Setter BigDecimal close;
	private @Getter @Setter BigDecimal high;
	private @Getter @Setter BigDecimal low;
	
	private @Getter @Setter BigDecimal assetVolume;
	private @Getter @Setter BigDecimal quoteVolume;
	
	private @Getter @Setter @JsonIgnore @ManyToOne(fetch = FetchType.LAZY, optional = false) Market market;

	/**
	 * @since 0.0.2
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetVolume == null) ? 0 : assetVolume.hashCode());
		result = prime * result + ((candlestickId == null) ? 0 : candlestickId.hashCode());
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((closeTimestamp == null) ? 0 : closeTimestamp.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((market == null) ? 0 : market.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((openTimestamp == null) ? 0 : openTimestamp.hashCode());
		result = prime * result + ((quoteVolume == null) ? 0 : quoteVolume.hashCode());
		return result;
	}

	/**
	 * @since 0.0.2
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Candlestick))
			return false;
		Candlestick other = (Candlestick) obj;
		if (assetVolume == null) {
			if (other.assetVolume != null)
				return false;
		} else if (!assetVolume.equals(other.assetVolume))
			return false;
		if (candlestickId == null) {
			if (other.candlestickId != null)
				return false;
		} else if (!candlestickId.equals(other.candlestickId))
			return false;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (closeTimestamp == null) {
			if (other.closeTimestamp != null)
				return false;
		} else if (!closeTimestamp.equals(other.closeTimestamp))
			return false;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (low == null) {
			if (other.low != null)
				return false;
		} else if (!low.equals(other.low))
			return false;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (openTimestamp == null) {
			if (other.openTimestamp != null)
				return false;
		} else if (!openTimestamp.equals(other.openTimestamp))
			return false;
		if (quoteVolume == null) {
			if (other.quoteVolume != null)
				return false;
		} else if (!quoteVolume.equals(other.quoteVolume))
			return false;
		return true;
	}
	
	/**
	 * @since 0.0.2
	 */
	@Override
	public String toString() {
		return "Candlestick [candlestickId=" + candlestickId + ", openTimestamp=" + openTimestamp + ", closeTimestamp="
				+ closeTimestamp + ", open=" + open + ", close=" + close + ", high=" + high + ", low=" + low
				+ ", assetVolume=" + assetVolume + ", quoteVolume=" + quoteVolume + ", market=" + market + "]";
	}	
}
