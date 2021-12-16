package com.dz_fs_dev.finance.liquidPoolMarkets.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing an Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Entity
public class LiquidPoolAsset implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -5977040732236444217L;

	private @Getter @Setter @GeneratedValue @Id long assetId;
	
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String symbol;
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String name;
	
	private @Getter @Setter @Column(nullable = false) BigDecimal lotSize;
	private @Getter @Setter @Column(nullable = false) BigInteger units;
	
	/**
	 * Default constructor for LiquidPoolAsset.
	 */
	public LiquidPoolAsset() {}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (assetId ^ (assetId >>> 32));
		result = prime * result + ((lotSize == null) ? 0 : lotSize.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		if (!(obj instanceof LiquidPoolAsset))
			return false;
		LiquidPoolAsset other = (LiquidPoolAsset) obj;
		if (assetId != other.assetId)
			return false;
		if (lotSize == null) {
			if (other.lotSize != null)
				return false;
		} else if (!lotSize.equals(other.lotSize))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}
}
