/*  Original Licensing Copyright
 * 
 *  Interface for various actions associated with a liquid pool market.
 *  Copyright (C) 2022  DZ-FSDev
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
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * The user of this interface should implement the various actions associated
 * with a liquid pool market service.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.10
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

	/**
	 * Removes a specific market from those to be tracked by the liquid pool
	 * exchange; returning true if successful.
	 * 
	 * @param asset The specified market to be removed.
	 * @return True if the removal was successful.
	 * @since 0.0.3
	 */
	boolean remove(Market market);
	
	/**
	 * Updates a specific market tracked by the liquid pool exchange; returning
	 * true if successful.
	 * 
	 * @param from The state which serves as an example to select the record
	 *             for updating.
	 * @param to The state the market should be updated to.
	 * @return True if the update was successful.
	 * @since 0.0.4
	 */
	@Transactional
	boolean update(Market from, Market to);
	
	/**
	 * Returns a list of markets which matches a given example market.
	 * 
	 * @param example The example market to be matched against.
	 * @return A list of markets which matches a given example market.
	 * @since 0.0.5
	 */
	List<Market> findByExample(Example<Market> example);
	
	/**
	 * Returns the price for a given liquid pool market for a given size of
	 * left asset and fee. Slippage is accounted for.
	 * 
	 * @param market The liquid market to assess the price from.
	 * @param size The units of left asset to be traded; negative sizes
	 *             indicate a sale of left asset.
	 * @param fee The fee percentage to be assessed per trade.
	 * @return The price for a given liquid pool market for a trade size of
	 *         left asset and fee with slippage accounted for.
	 * @since 0.0.6
	 */
	public BigDecimal price(Market market, BigDecimal size, BigDecimal fee);

	/**
	 * Returns the price for a given liquid pool market for a given trade fee.
	 * 
	 * @param market The liquid market to assess the price from.
	 * @param fee The fee percentage to be assessed per trade.
	 * @return The price for a given liquid pool market for a given trade fee.
	 * @since 0.0.7
	 */
	public default BigDecimal price(Market market, BigDecimal fee) {
		return price(market, BigDecimal.ZERO, fee);
	}
	
	/**
	 * Returns the price for a given liquid pool market discounting the fee.
	 * 
	 * @param market The liquid market to assess the price from.
	 * @return The price for a given liquid pool market discounting the fee.
	 * @since 0.0.8
	 */
	public default BigDecimal price(Market market) {
		return price(market, BigDecimal.ZERO);
	}
	
	/**
	 * Returns a chart in CSV format for a given ticker which maps to a liquid
	 * pool market tracked. The CSV shall contain a header defining the column
	 * data. The columns shall contain ohlcv-ts data.
	 * 
	 * @param ticker The ticker to generate the CSV chart data for.
	 * @return The CSV formatted ohlcv-ts data for a given ticker.
	 * @since 0.0.9
	 */
	public String getChartCSV(String ticker);
	
	/**
	 * Closes expired candles. The implementation should not require explicit
	 * invokation and should be annotated for periodic scheduling. For example:
	 * <p><i>@Scheduled(initialDelay, fixedDelay)</i>
	 * <p>Or if it makes more sense to have cron-based candle closure.</p>
	 * <i>@Scheduled(cron = "${cron.expression}")</i>
	 * <p>Optionally, can also be annotated to run asynchronously.
	 * 
	 * @since 0.0.10
	 */
	public void closeCandles();
}
