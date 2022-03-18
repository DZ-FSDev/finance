package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Account entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.6
 */
public interface IAccountRepository extends ReactiveCrudRepository<Account, Long> {
	/*
	 *  -- Read --
	 */
	public Mono<Account> findByName(String name);
	
	public <T> Flux<T> findFirst3ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst5ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst10ByOrderByRealizedPNL(Class<T> type);
	public <T> Flux<T> findFirst100ByOrderByRealizedPNL(Class<T> type);
	
	/*
	 *  -- Delete --
	 */
	public Mono<Boolean> deleteByName(String name);
}
