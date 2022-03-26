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

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.13
 */
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Market implements IMarket{
	private @Id Long id;
	
	private String ticker;

	private Long leftAssetId;
	private Long rightAssetId;
}
