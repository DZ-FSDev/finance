package com.dz_fs_dev.finance.liquidPoolMarkets.liquidAccountExchange;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder.DTOLiquidOrder;

import reactor.core.publisher.Mono;

/**
 * v1/liquid/exchange/accounts REST Service Controller.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@RestController
@RequestMapping("/v1/liquid/exchange/accounts")
public class RESTController_v1_liquid_exchange_accounts {
	@Autowired
	IAccountExchangeService svc;
	
	@GetMapping("/placeOrder")
	public Mono<DTOLiquidOrder> placeOrder(Long accountId, Long marketId, BigInteger units){
		return svc.placeOrder(accountId, marketId, units);
	}
}
