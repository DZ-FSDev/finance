package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * liquid/assets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.7
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
		model.addAttribute("updDTO", new AssetUpdateDTO());
		
		return "/liquid/assets/index";
	}
	
	/**
	 * 
	 * @param asset
	 * @param model
	 * @return
	 * @since 0.0.7
	 */
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
	 */
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
	 */
	@PostMapping("/update")//
	public ModelAndView updateAsset(@ModelAttribute("updDTO") AssetUpdateDTO updDTO, ModelMap model) {
		assetSvc.update(updDTO.from, updDTO.to);
				
		return new ModelAndView("redirect:/liquid/assets", model);
	}
}
