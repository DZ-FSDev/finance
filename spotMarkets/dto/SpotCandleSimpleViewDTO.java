package com.dz_fs_dev.finance.spotMarkets.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object representing an Spot Candle Stick for read-only operations.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public class SpotCandlestickSimpleViewDTO {
	private @Getter @Setter BigDecimal open;
	private @Getter @Setter BigDecimal high;
	private @Getter @Setter BigDecimal low;
	private @Getter @Setter BigDecimal close;
	private @Getter @Setter BigDecimal quoteVolume;
	private @Getter @Setter BigInteger assetVolume;

	private @Getter @Setter Long startTimeStamp;
	private @Getter @Setter Long endTimeStamp;
	
	/**
	 * Constructs a new SpotCandlestickSimpleViewDTO.
	 * 
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param quoteVolume
	 * @param assetVolume
	 * @param startTimeStamp
	 * @param endTimeStamp
	 */
	public SpotCandlestickSimpleViewDTO(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close,
			BigDecimal quoteVolume, BigInteger assetVolume, Long startTimeStamp, Long endTimeStamp) {
		super();
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.quoteVolume = quoteVolume;
		this.assetVolume = assetVolume;
		this.startTimeStamp = startTimeStamp;
		this.endTimeStamp = endTimeStamp;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetVolume == null) ? 0 : assetVolume.hashCode());
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((endTimeStamp == null) ? 0 : endTimeStamp.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((quoteVolume == null) ? 0 : quoteVolume.hashCode());
		result = prime * result + ((startTimeStamp == null) ? 0 : startTimeStamp.hashCode());
		return result;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotCandlestickSimpleViewDTO))
			return false;
		SpotCandlestickSimpleViewDTO other = (SpotCandlestickSimpleViewDTO) obj;
		if (assetVolume == null) {
			if (other.assetVolume != null)
				return false;
		} else if (!assetVolume.equals(other.assetVolume))
			return false;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (endTimeStamp == null) {
			if (other.endTimeStamp != null)
				return false;
		} else if (!endTimeStamp.equals(other.endTimeStamp))
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
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (quoteVolume == null) {
			if (other.quoteVolume != null)
				return false;
		} else if (!quoteVolume.equals(other.quoteVolume))
			return false;
		if (startTimeStamp == null) {
			if (other.startTimeStamp != null)
				return false;
		} else if (!startTimeStamp.equals(other.startTimeStamp))
			return false;
		return true;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public String toString() {
		return "SpotCandlestickSimpleViewDTO [open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
				+ ", quoteVolume=" + quoteVolume + ", assetVolume=" + assetVolume + ", startTimeStamp=" + startTimeStamp
				+ ", endTimeStamp=" + endTimeStamp + "]";
	}
}
