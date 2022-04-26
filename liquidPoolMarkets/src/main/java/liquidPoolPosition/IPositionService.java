package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * The user of this interface should implement the various actions associated
 * with a liquid pool position services.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
@Service
public interface IPositionService {
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param id
	 * @return
	 * @since 0.0.2
	 */
	<T extends IPosition> Flux<T> findByAccountId(Class<T> type, Long id);
}
