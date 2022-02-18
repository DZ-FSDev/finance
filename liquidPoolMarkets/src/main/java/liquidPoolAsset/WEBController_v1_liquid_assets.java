package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * liquid/assets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@Controller
@RequestMapping("/liquid/assets")
public class WEBController_liquid_assets {
	@Autowired
	IAssetService assetSvc;
	
	@GetMapping
	public String get(Model model) {
		return "/liquid/assets/index";
	}
}