package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolTrade;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Trade entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
public interface ITradeRepository extends R2dbcRepository<DTOTrade, Long>{
	/*
	 *  -- Read --
	 */
	<T> Flux<T> findAllBy(Class<T> type);
	
	/*
	 *  -- Delete --
	 */
}
