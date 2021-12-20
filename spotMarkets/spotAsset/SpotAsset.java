package com.dz_fs_dev.finance.spotMarkets.spotAsset;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing an Asset in spot markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Entity
public class SpotAsset implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -702153586272856119L;

	private @Getter @Setter @GeneratedValue @Id long assetId;
	
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String symbol;
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String name;
	
	/**
	 * Default constructor for SpotAsset.
	 */
	public SpotAsset() {}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 62627;
		int result = 1;
		result = prime * result + (int) (assetId ^ (assetId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotAsset))
			return false;
		SpotAsset other = (SpotAsset) obj;
		if (assetId != other.assetId)
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
		return true;
	}
}
