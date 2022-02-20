package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * liquid/assets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.5
 */
@Controller
@RequestMapping("/liquid/assets")
public class WEBController_liquid_assets {
	@Autowired
	IAssetService assetSvc;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String get(Model model) {
		model.addAttribute("assets", assetSvc.getAllAssets());
		
		return "/liquid/assets/index";
	}
	
	/**
	 * 
	 * @param asset
	 * @param model
	 * @return
	 */
	@PostMapping("/create")
	public String createAsset(Asset asset, Model model) {
		assetSvc.add(asset);
				
		return get(model);
	}
	
	/**
	 * 
	 * @param asset
	 * @param model
	 * @return
	 */
	@PostMapping("/delete")
	public String deleteAsset(Asset asset, Model model) {
		assetSvc.remove(asset);
				
		return get(model);
	}
}
