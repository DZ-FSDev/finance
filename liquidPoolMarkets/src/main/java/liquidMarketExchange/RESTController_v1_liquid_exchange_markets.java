package com.dz_fs_dev.finance.liquidPoolMarkets.liquidMarketExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * v1/liquid/exchange/markets REST Service Controller.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@RestController
@RequestMapping("/v1/liquid/exchange/markets")
public class RESTController_v1_liquid_exchange_markets {
	@Autowired
	IMarketExchangeService svc;
	
	@GetMapping("/priceInfo/{marketId}")
	public Mono<DTOMarketPricing> getMarketPricing(@PathVariable Long marketId){
		return svc.getMarketPricing(marketId);
	}
}
