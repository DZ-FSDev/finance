package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * liquid/assets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@Controller
@RequestMapping("/liquid/accounts")
public class WEBController_liquid_accounts {
	@Autowired
	IAccountService accountSvc;
	
}
