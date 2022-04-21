package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

/**
 * v1/liquid/orders REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@RestController
@RequestMapping("/v1/liquid/orders")
public class RESTController_v1_liquid_orders{
	@Autowired
	ILiquidOrderService orderSvc;
}
