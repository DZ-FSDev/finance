/*  Original Licensing Copyright
 * 
 *  Represents a liquid pool market.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a liquid pool market.
 * 
 * @author DZ-FSDev
 * @version 0.0.5
 * @since 17.0.1
 */
@Entity
public class Market implements Serializable{
	/**
	 * @since 0.0.5
	 */
	private static final long serialVersionUID = -7379579094660653100L;

	private @Getter @Setter @GeneratedValue @Id long marketId;
	
	private @Getter @Setter @Column(unique = true, nullable = false, updatable = false) String ticker;
	
	private @Getter @Setter @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false) Asset leftAsset;
	private @Getter @Setter @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false) Asset rightAsset;
	
	/**
	 * Default constructor for Liquid Pool Market.
	 */
	public Market() {}

	/**
	 * @since 0.0.4
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leftAsset == null) ? 0 : leftAsset.hashCode());
		result = prime * result + (int) (marketId ^ (marketId >>> 32));
		result = prime * result + ((rightAsset == null) ? 0 : rightAsset.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		return result;
	}

	/**
	 * @since 0.0.5
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Market))
			return false;
		Market other = (Market) obj;
		if (leftAsset == null) {
			if (other.leftAsset != null)
				return false;
		} else if (!leftAsset.equals(other.leftAsset))
			return false;
		if (marketId != other.marketId)
			return false;
		if (rightAsset == null) {
			if (other.rightAsset != null)
				return false;
		} else if (!rightAsset.equals(other.rightAsset))
			return false;
		if (ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!ticker.equals(other.ticker))
			return false;
		return true;
	}
	
	/**
	 * @since 0.0.2
	 */
	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", ticker=" + ticker + ", leftAsset=" + leftAsset.getName() + ", rightAsset="
				+ rightAsset.getName() + "]";
	}
}
