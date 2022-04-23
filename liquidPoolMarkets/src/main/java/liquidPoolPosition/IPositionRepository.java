package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Position entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.7
 */
public interface IPositionRepository extends R2dbcRepository<DTOPosition, Long>{
	/*
	 *  -- Read --
	 */
	<T extends IPosition> Flux<T> findAllBy(Class<T> type);
	<T extends IPosition> Flux<T> findByAccountId(Class<T> type, Long accountId);
	
	<T extends IPosition> Flux<T> findByAccountIdAndAssetId(Class<T> type, Long accountId, Long assetId);
	/*
	 *  -- Delete --
	 */
}
