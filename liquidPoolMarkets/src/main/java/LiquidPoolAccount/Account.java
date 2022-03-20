/*  Original Licensing Copyright
 * 
 *  Represents an Account in liquid pool markets.
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
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements IAccount{
	private @Id Long id;
	
	private String firstName;
	private String lastName;
	private @Transient BigDecimal unrealizedPNL;
	private BigDecimal realizedPNL;
}
