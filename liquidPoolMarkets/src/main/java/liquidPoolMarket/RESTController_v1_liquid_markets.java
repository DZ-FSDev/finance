package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * v1/liquid/markets REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@RestController
@RequestMapping("/v1/liquid/markets")
public class RESTController_v1_liquid_markets {
	@Autowired
	IMarketService marketSvc;
	
	@GetMapping(value = "/list")
	public List<Market> getAllMarkets(){
		return marketSvc.getAllMarkets();
	}
}
