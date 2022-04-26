/*  Original Licensing Copyright
 * 
 *  v1/liquid/candles REST Service Controller.
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
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * v1/liquid/candles REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.4
 */
@RestController
@RequestMapping("/v1/liquid/candles")
public class RESTController_v1_liquid_candles{
	@Autowired
	ICandlestickService candleSvc;
	
	@GetMapping(value = "/list")
	public Flux<DTOCandlestick> getByMarketId(Long marketId){
		return candleSvc.getCandlesticksByMarketId(marketId);
	}
	
	@GetMapping(value = "/current")
	public Mono<DTOCandlestick> getCurrentByMarketId(Long marketId){
		return candleSvc.getTopByMarketIdOrderByOpenTSDesc(marketId);
	}
	
	@GetMapping(value = "/save")
	public Mono<DTOCandlestick> save(DTOCandlestick candle){
		return candleSvc.save(candle);
	}
}
