package com.dz_fs_dev.finance.liquidPoolMarkets.liquidAccountExchange;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder.ILiquidOrder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with a liquid pool account exchange services.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Service
public interface IAccountExchangeService {
	/**
	 * 
	 * @param <T>
	 * @param accountId
	 * @param marketId
	 * @param units
	 * @return
	 * @since 0.0.1
	 */
	<T extends ILiquidOrder> Mono<T> placeOrder(Long accountId, Long marketId, BigInteger units);
}
