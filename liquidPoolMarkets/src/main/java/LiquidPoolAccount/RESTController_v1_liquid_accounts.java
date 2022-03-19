package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * v1/liquid/accounts REST Service Controller.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.3
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
	 * @since 0.0.3
	 */
	@GetMapping("/{name}")
	public Account get(@PathVariable("name") String name) {
		return accountSvc.findByName(Account.class, name);
	}
}
