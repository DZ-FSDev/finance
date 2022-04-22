package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Persistence layer for Liquid Order entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.7
 */
public interface IOrderRepository extends R2dbcRepository<DTOLiquidOrder, Long>{
	/*
	 *  -- Read --
	 */
	<T extends ILiquidOrder> Flux<T> getOrdersByAccountId(Class<T> type, Long accountId);
	<T extends ILiquidOrder> Flux<T> getOrdersByMarketIdOrderByTs(Class<T> type, Long marketId);
	
	<T extends ILiquidOrder> Flux<T> getOrdersByAccountIdAndStatus(Class<T> type, Long accountId, OrderStatus status);
	<T extends ILiquidOrder> Mono<T> getOrdersByMarketIdAndStatusOrderByTs(Class<T> type, Long marketId, OrderStatus status);
	<T extends ILiquidOrder> Flux<T> findOrdersByMarketIdAndStatusOrderByTs(Class<T> type, Long marketId, OrderStatus status);
	/*
	 *  -- Update --
	 */
}
