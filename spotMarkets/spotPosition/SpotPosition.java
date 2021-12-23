package com.dz_fs_dev.finance.spotMarkets.spotPosition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dz_fs_dev.finance.spotMarkets.spotAsset.SpotAsset;
import com.dz_fs_dev.finance.spotMarkets.spotTrade.SpotTrade;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing an Position placed in a spot market.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Entity
public class SpotPosition implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -1770145062247747367L;
	
	private @Getter @Setter @Id @GeneratedValue Long positionId;
	private @Getter @Setter @OneToOne(fetch = FetchType.LAZY) SpotAsset asset;
	
	private @Getter @Setter BigDecimal free;
	private @Getter @Setter BigDecimal locked;
	private @Getter @Setter @JsonIgnore BigDecimal costBasis;
	private @Getter @Setter @JsonIgnore BigDecimal pnl;
	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY) List<SpotTrade> trades;
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 561991513;
		int result = 1;
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result + ((costBasis == null) ? 0 : costBasis.hashCode());
		result = prime * result + ((free == null) ? 0 : free.hashCode());
		result = prime * result + ((locked == null) ? 0 : locked.hashCode());
		result = prime * result + ((positionId == null) ? 0 : positionId.hashCode());
		result = prime * result + ((trades == null) ? 0 : trades.hashCode());
		return result;
	}
	
	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotPosition))
			return false;
		SpotPosition other = (SpotPosition) obj;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		if (costBasis == null) {
			if (other.costBasis != null)
				return false;
		} else if (!costBasis.equals(other.costBasis))
			return false;
		if (free == null) {
			if (other.free != null)
				return false;
		} else if (!free.equals(other.free))
			return false;
		if (locked == null) {
			if (other.locked != null)
				return false;
		} else if (!locked.equals(other.locked))
			return false;
		if (positionId == null) {
			if (other.positionId != null)
				return false;
		} else if (!positionId.equals(other.positionId))
			return false;
		if (trades == null) {
			if (other.trades != null)
				return false;
		} else if (!trades.equals(other.trades))
			return false;
		return true;
	}
}
