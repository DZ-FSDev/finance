package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Position entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
public interface PositionRepository extends R2dbcRepository<Position, Long>{
	/*
	 *  -- Read --
	 */
	public <T> Flux<T> findAllBy(Class<T> type);
	
	/*
	 *  -- Delete --
	 */
}
