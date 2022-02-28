/*  Original Licensing Copyright
 * 
 *  Represents a liquid pool market account name and realized PNL.
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
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.math.BigDecimal;

import lombok.Getter;

/**
 * Represents a class based projection of an {@link Account} linking the
 * name of the owner and their realized PNL in the liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public class AccountRealizedPNLDTO {
	private @Getter String name;
	private @Getter BigDecimal realizedPNL;
	
	/**
	 * Initializes an instance of this DTO containing an account name and
	 * associated realized PNL.
	 * 
	 * @param name The name of the account holder.
	 * @param realizedPNL The current PNL realized by the account.
	 * @since 0.0.1
	 */
	public AccountRealizedPNLDTO(String name, BigDecimal realizedPNL) {
		this.name = name;
		this.realizedPNL = realizedPNL;
	}
}
