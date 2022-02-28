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
 * @version 17.0.2
 * @since 0.0.1
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
	 * @since 0.0.2
	 */
	@GetMapping("/{name}")
	public Account get(@PathVariable("name") String name) {
		return accountSvc.findByName(name);
	}
}
