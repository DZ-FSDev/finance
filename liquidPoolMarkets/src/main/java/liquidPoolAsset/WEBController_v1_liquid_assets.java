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
 * @since 17.0.2
 * @version 0.0.8
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
	 * @since 0.0.3
	 */
	@GetMapping
	public String get(Model model) {
		model.addAttribute("assets", assetSvc.getAllAssets());
		model.addAttribute("assetClasses", AssetClass.values());
		model.addAttribute("updDTO", new AssetUpdateDTO());
		
		return "/liquid/assets/index";
	}
	
	/**
	 * 
	 * @param asset
	 * @param model
	 * @return
	 * @since 0.0.7
	 *
	@PostMapping("/create")
	public ModelAndView createAsset(Asset asset, ModelMap model) {
		assetSvc.add(asset);
				
		return new ModelAndView("redirect:/liquid/assets", model);
	}
	
	/**
	 * 
	 * @param asset
	 * @param model
	 * @return
	 * @since 0.0.7
	 *
	@PostMapping("/delete")
	public ModelAndView deleteAsset(Asset asset, ModelMap model) {
		assetSvc.remove(asset);
				
		return new ModelAndView("redirect:/liquid/assets", model);
	}
	
	/**
	 * 
	 * @param updDTO
	 * @param model
	 * @return
	 * @since 0.0.7
	 *
	@PostMapping("/update")
	public ModelAndView updateAsset(@ModelAttribute("updDTO") AssetUpdateDTO updDTO, ModelMap model) {
		assetSvc.update(updDTO.from, updDTO.to);
				
		return new ModelAndView("redirect:/liquid/assets", model);
	}
	*/
}
