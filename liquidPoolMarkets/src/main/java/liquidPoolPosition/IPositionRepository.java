package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Position entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.5
 */
public interface IPositionRepository extends R2dbcRepository<Position, Long>{
	/*
	 *  -- Read --
	 */
	<T> Flux<T> findAllBy(Class<T> type);
	<T> Flux<T> findByAccountId(Class<T> type, Long accountId);
	
	<T> Flux<T> findByAccountIdAndAssetId(Class<T> type, Long accountId, Long assetId);
	/*
	 *  -- Delete --
	 */
}
