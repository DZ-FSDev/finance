package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolTradeActivity;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool trade activity service.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.2
 */
@Service
public interface ITradeActivityService {
	/**
	 * 
	 * @return
	 * @since 0.0.2
	 */
	String getActivity();

	/**
	 * 
	 * @param activity
	 * @return
	 * @since 0.0.3
	 */
	String postActiviy(String activity);
}
