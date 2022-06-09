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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Asset in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.10
 * @since 17.0.2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Asset implements IAsset{
	private @Id Long id;

	private String symbol;
	private String name;

	private BigInteger units;
	private BigInteger coldUnits;
	private BigDecimal lastPrice;
	private AssetClass assetClass;
}
