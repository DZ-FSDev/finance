/*  Original Licensing Copyright
 * 
 *  Reactive persistence layer for Liquid Account entities.
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

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive persistence layer for Liquid {@link Account} entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.7
 */
public interface IAccountRepository extends ReactiveCrudRepository<Account, Long> {
	/*
	 *  -- Read --
	 */
	public <T> Mono<T> findByName(Class<T> type, String firstName, String lastName);
	
	public <T> Flux<T> findFirst3ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst5ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst10ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst100ByOrderByRealizedPNL(Class<T> type);
	
	/*
	 *  -- Delete --
	 */
	public Mono<Boolean> deleteByName(String name);
}
