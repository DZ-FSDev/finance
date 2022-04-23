package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param marketId
	 * @return
	 * @since 0.0.3
	 */
	<T extends ILiquidOrder> Flux<T> findByMarketId(Class<T> type, Long marketId);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param accountId
	 * @return
	 * @since 0.0.3
	 */
	<T extends ILiquidOrder> Flux<T> findByAccountId(Class<T> type, Long accountId);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param accountId
	 * @param status
	 * @return
	 * @since 0.0.4
	 */
	<T extends ILiquidOrder> Flux<T> getOrdersByAccountIdAndStatus(Class<T> type, Long accountId, OrderStatus status);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param marketId
	 * @param status
	 * @return
	 * @since 0.0.5
	 */
	<T extends ILiquidOrder> Mono<T> getOrdersByMarketIdAndStatusOrderByTs(Class<T> type, Long marketId, OrderStatus status);
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param marketId
	 * @param status
	 * @return
	 * @since 0.0.5
	 */
	<T extends ILiquidOrder> Flux<T> findOrdersByMarketIdAndStatusOrderByTs(Class<T> type, Long marketId, OrderStatus status);
}
