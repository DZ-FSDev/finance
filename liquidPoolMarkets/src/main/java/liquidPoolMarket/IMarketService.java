package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * The user of this interface should implement the various actions associated
 * with an liquid pool market service.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
@Service
public interface IMarketService {
	/**
	 * Returns the List containing all markets tracked by this liquid pool
	 * exchange.
	 * 
	 * @return The set containing all markets tracked by this liquid pool
	 *         exchange.
	 * @since 0.0.1
	 */
	List<Market> getAllMarkets();

	/**
	 * Adds a specific market to be tracked by the liquid pool exchange;
	 * returning true if successful.
	 * 
	 * @param market The market to be added.
	 * @return True if the addition was successful.
	 * @since 0.0.2
	 */
	boolean add(Market market);
}
