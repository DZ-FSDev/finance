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
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.1
 */
@Entity
public class LiquidPoolAsset implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -5977040732236444217L;

	private @Getter @Setter @GeneratedValue @Id Long assetId;
	
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String symbol;
	private @Getter @Setter @Column(nullable = false, unique = true, updatable = false) String name;
	
	private @Getter @Setter @Column(nullable = false) BigInteger units;
	private @Getter @Setter @Column(nullable = false) BigDecimal lastPrice;
	private @Getter @Setter @Formula("units * last_price") BigDecimal marketCap;
	private @Getter @Setter @Column(nullable = false) @Enumerated(EnumType.STRING) AssetClass assetClass;

	@Override
	public int hashCode() {
		final int prime = 67011;
		int result = 1;
		result = prime * result + (int) (assetId ^ (assetId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LiquidPoolAsset))
			return false;
		LiquidPoolAsset other = (LiquidPoolAsset) obj;
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
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}
}
