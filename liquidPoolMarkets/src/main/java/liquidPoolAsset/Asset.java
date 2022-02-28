/*  Original Licensing Copyright
 * 
 *  Represents an Asset in liquid pool markets.
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
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.6
 * @since 17.0.2
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Asset implements Serializable{
	/**
	 * @since 0.0.5
	 */
	private static final long serialVersionUID = 3905359730407435980L;

	private @Getter @Setter @GeneratedValue @Id Long id;

	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String symbol;
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String name;

	private @Getter @Setter @Column(nullable = false) BigInteger units;
	private @Getter @Setter @Column(nullable = false) BigDecimal lastPrice;
	private @Getter @Setter @Formula("units * last_price") BigDecimal marketCap;
	private @Getter @Setter @Column(nullable = false) @Enumerated(EnumType.STRING) AssetClass assetClass;

	/**
	 * @since 0.0.6
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetClass == null) ? 0 : assetClass.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastPrice == null) ? 0 : lastPrice.hashCode());
		result = prime * result + ((marketCap == null) ? 0 : marketCap.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		return result;
	}

	/**
	 * @since 0.0.6
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Asset))
			return false;
		Asset other = (Asset) obj;
		if (assetClass != other.assetClass)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastPrice == null) {
			if (other.lastPrice != null)
				return false;
		} else if (!lastPrice.equals(other.lastPrice))
			return false;
		if (marketCap == null) {
			if (other.marketCap != null)
				return false;
		} else if (!marketCap.equals(other.marketCap))
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

	/**
	 * @since 0.0.6
	 */
	@Override
	public String toString() {
		return "Asset [id=" + id + ", symbol=" + symbol + ", name=" + name + ", units=" + units
				+ ", lastPrice=" + lastPrice + ", marketCap=" + marketCap + ", assetClass=" + assetClass + "]";
	}
}
