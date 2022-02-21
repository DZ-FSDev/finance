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
import javax.persistence.Entity;
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
 * @version 0.0.2
 * @since 17.0.1
 */
@Entity
public class Market implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 5586298732449963244L;

	private @Getter @Setter @GeneratedValue @Id long marketId;
	
	private @Getter @Setter String ticker;
	
	private @Getter @Setter @ManyToOne Asset leftAsset;
	private @Getter @Setter @ManyToOne Asset rightAsset;
	
	/**
	 * Default constructor for Liquid Pool Market.
	 */
	public Market() {}

	/**
	 * @since 0.0.2
	 */
	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", ticker=" + ticker + ", leftAsset=" + leftAsset.getName() + ", rightAsset="
				+ rightAsset.getName() + "]";
	}
	
	
}
