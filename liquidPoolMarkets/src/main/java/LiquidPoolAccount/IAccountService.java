/*  Original Licensing Copyright
 * 
 *  Various actions an liquid pool account service performs.
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

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool account service.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.6
 */
@Service
public interface IAccountService {
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param id
	 * @return
	 * @since 0.0.6
	 */
	<T extends IAccount> Mono<T> findById(Class<T> type, Long id);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param firstName
	 * @param lastName
	 * @return
	 * @since 0.0.2
	 */
	<T extends IAccount> Mono<T> findByName(Class<T> type, String firstName, String lastName);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param firstNamePattern
	 * @return
	 * @since 0.0.5
	 */
	<T extends IAccount> Flux<T> findByFirstNameLike(Class<T> type, String firstNamePattern);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param x
	 * @return
	 * @since 0.0.3
	 */
	<T> Flux<T> findTopXByOrderByRealizedPNL(Class<T> type, int x);
}
