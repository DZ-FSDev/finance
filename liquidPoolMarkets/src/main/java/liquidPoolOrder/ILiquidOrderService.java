package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * The user of this interface should implement the various actions associated
 * with a liquid pool order services.
 * 
 * @author DZ-FSDev
 * @version 0.0.5
 * @since 17.0.1
 */
@Service
public interface ILiquidOrderService {
	<T  extends ILiquidOrder> Flux<T> findByMarketId(Class<T> type, Long marketId);
	<T  extends ILiquidOrder> Flux<T> findByAccountId(Class<T> type, Long accountId);
	
	<T extends ILiquidOrder> Flux<T> getOrdersByAccountIdAndStatus(Class<T> type, Long accountId, OrderStatus status);
	<T extends ILiquidOrder> Mono<T> getOrdersByMarketIdAndStatusOrderByTs(Class<T> type, Long marketId, OrderStatus status);
}
