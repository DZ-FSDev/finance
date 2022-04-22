package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * v1/liquid/accounts REST Service Controller.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.6
 */
@RestController
@RequestMapping("/v1/liquid/accounts")
public class RESTController_v1_liquid_accounts {
	@Autowired
	IAccountService accountSvc;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @since 0.0.6
	 */
	@GetMapping("/{name}")
	public Flux<DTOAccount> get(@PathVariable("name") String name) {
		return accountSvc.findByFirstNameLike(DTOAccount.class, name);
	}
}
