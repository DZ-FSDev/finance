package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * v1/liquid WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Controller
@RequestMapping("/v1/liquid/assets")
public class WEBController_v1_liquid_assets {
	@Autowired
	IAssetService assetSvc;
	
	@GetMapping
	public String get() {
		return "AssetList";
	}
}
