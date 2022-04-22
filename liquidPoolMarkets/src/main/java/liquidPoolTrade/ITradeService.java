package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolTrade;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * The user of this interface should implement the various actions associated
 * with a liquid pool trade services.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
@Service
public interface ITradeService {
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param id
	 * @return
	 * @since 0.0.2
	 */
	<T extends ITrade> Flux<T> findByAccountId(Class<T> type, Long id);
}
