package com.dz_fs_dev.finance.markets.interfaces.strategies;

import java.util.Collection;
import com.dz_fs_dev.finance.markets.interfaces.IOrder;
import com.dz_fs_dev.finance.markets.interfaces.ITrade;

/**
 * The user of this interface should implement logic to identify from an order
 * book the next best long and short as well as execution logic for matched
 * orders.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public interface IExchangeOrderMatchingStrategy {
	/**
	 * Returns the next long order to be matched.
	 * 
	 * @param longs The collection of orders representing the long order book.
	 * @return The next long order to be matched.
	 * @since 0.0.2
	 */
	public IOrder indexOfNextLong(Collection<IOrder> longs);
	
	/**
	 * Returns the next short order to be matched.
	 * 
	 * @param shorts The collection of orders representing the short order book.
	 * @return The next long order to be matched.
	 * @since 0.0.2
	 */
	public int indexOfNextShort(Collection<IOrder> shorts);
	
	/**
	 * Executes and returns a trade given a long and short order. 
	 * 
	 * @param longOrder The specified long order to be executed against.
	 * @param shortOrder The specified short order to be executed against.
	 * @return The trade record detailing the executed orders against each other.
	 * @since 0.0.2
	 */
	public ITrade executeTrade(IOrder longOrder, IOrder shortOrder);
}
