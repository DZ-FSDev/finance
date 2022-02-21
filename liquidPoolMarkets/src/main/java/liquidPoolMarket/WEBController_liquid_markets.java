package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * liquid/markets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Controller
@RequestMapping("/liquid/markets")
public class WEBController_liquid_markets {
	@Autowired
	IMarketService marketSvc;
}
