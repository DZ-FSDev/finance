/*  Original Licensing Copyright
 * 
 *  The user of this interface should implement logic to identify from an order
 *  book the next best long and short as well as execution logic for matched
 *  orders.
 *  Copyright (C) 2021  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
	 * @return The next short order to be matched.
	 * @since 0.0.2
	 */
	public IOrder indexOfNextShort(Collection<IOrder> shorts);
	
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
