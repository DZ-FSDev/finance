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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;
import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick.Candlestick;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.10
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Market implements Serializable{
	/**
	 * @since 0.0.10
	 */
	private static final long serialVersionUID = -4314368212634384965L;

	private @Getter @Setter @GeneratedValue @Id long marketId;
	
	private @Getter @Setter @Column(unique = true, nullable = false, updatable = false) String ticker;
	
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks1m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks5m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks15m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks30m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks60m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks120m;
	private @Getter @Setter @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) List<Candlestick> candlesticks240m;
	
	private @Getter @Setter @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false) Asset leftAsset;
	private @Getter @Setter @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false) Asset rightAsset;
	
	/**
	 * Default constructor for Liquid Pool Market.
	 */
	public Market() {}

	/**
	 * @since 0.0.10
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candlesticks120m == null) ? 0 : candlesticks120m.hashCode());
		result = prime * result + ((candlesticks15m == null) ? 0 : candlesticks15m.hashCode());
		result = prime * result + ((candlesticks1m == null) ? 0 : candlesticks1m.hashCode());
		result = prime * result + ((candlesticks240m == null) ? 0 : candlesticks240m.hashCode());
		result = prime * result + ((candlesticks30m == null) ? 0 : candlesticks30m.hashCode());
		result = prime * result + ((candlesticks5m == null) ? 0 : candlesticks5m.hashCode());
		result = prime * result + ((candlesticks60m == null) ? 0 : candlesticks60m.hashCode());
		result = prime * result + ((leftAsset == null) ? 0 : leftAsset.hashCode());
		result = prime * result + (int) (marketId ^ (marketId >>> 32));
		result = prime * result + ((rightAsset == null) ? 0 : rightAsset.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		return result;
	}

	/**
	 * @since 0.0.10
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Market))
			return false;
		Market other = (Market) obj;
		if (candlesticks120m == null) {
			if (other.candlesticks120m != null)
				return false;
		} else if (!candlesticks120m.equals(other.candlesticks120m))
			return false;
		if (candlesticks15m == null) {
			if (other.candlesticks15m != null)
				return false;
		} else if (!candlesticks15m.equals(other.candlesticks15m))
			return false;
		if (candlesticks1m == null) {
			if (other.candlesticks1m != null)
				return false;
		} else if (!candlesticks1m.equals(other.candlesticks1m))
			return false;
		if (candlesticks240m == null) {
			if (other.candlesticks240m != null)
				return false;
		} else if (!candlesticks240m.equals(other.candlesticks240m))
			return false;
		if (candlesticks30m == null) {
			if (other.candlesticks30m != null)
				return false;
		} else if (!candlesticks30m.equals(other.candlesticks30m))
			return false;
		if (candlesticks5m == null) {
			if (other.candlesticks5m != null)
				return false;
		} else if (!candlesticks5m.equals(other.candlesticks5m))
			return false;
		if (candlesticks60m == null) {
			if (other.candlesticks60m != null)
				return false;
		} else if (!candlesticks60m.equals(other.candlesticks60m))
			return false;
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
	 * @since 0.0.10
	 */
	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", ticker=" + ticker + ", candlesticks1m=" + candlesticks1m
				+ ", candlesticks5m=" + candlesticks5m + ", candlesticks15m=" + candlesticks15m + ", candlesticks30m="
				+ candlesticks30m + ", candlesticks60m=" + candlesticks60m + ", candlesticks120m=" + candlesticks120m
				+ ", candlesticks240m=" + candlesticks240m + ", leftAsset=" + leftAsset + ", rightAsset=" + rightAsset
				+ "]";
	}
}
