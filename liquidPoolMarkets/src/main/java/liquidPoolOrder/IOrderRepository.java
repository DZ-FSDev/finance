package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

/**
 * Persistence layer for Liquid Order entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.4
 */
public interface IOrderRepository extends R2dbcRepository<DTOLiquidOrder, Long>{
	/*
	 *  -- Read --
	 */
	<T extends ILiquidOrder> Flux<T> getOrdersByAccountId(Class<T> type, Long accountId);
	<T extends ILiquidOrder> Flux<T> getOrdersByMarketIdOrderByTs(Class<T> type, Long marketId);
	
	/*
	 *  -- Update --
	 */
}
