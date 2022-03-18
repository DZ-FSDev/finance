package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.stereotype.Service;

import com.dz_fs_dev.finance.markets.interfaces.IAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool account service.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@Service
public interface IAccountService {
	public <T extends IAccount> Mono<T> findByName(Class<T> type, String name);
	public <T> Flux<T> findTopXByOrderByRealizedPNL(Class<T> type, int x);
}
