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
 * @version 0.0.5
 */
@Controller
@RequestMapping("/liquid/markets")
public class WEBController_liquid_markets {
	@Autowired
	IMarketService marketSvc;
	
	/**
	 * 
	 * @param model
	 * @return
	 * @since 0.0.5
	 */
	@GetMapping
	public String get(Model model) {
		model.addAttribute("markets", marketSvc.getAllMarkets());
		model.addAttribute("updDTO", new MarketUpdateDTO());
		
		return "/liquid/markets/index";
	}
	
	/**
	 * 
	 * @param market
	 * @param model
	 * @return
	 * @since 0.0.3
	 */
	@PostMapping("/create")
	public ModelAndView createMarket(Market market, ModelMap model) {
		marketSvc.add(market);
				
		return new ModelAndView("redirect:/liquid/markets", model);
	}
	
	/**
	 * 
	 * @param market
	 * @param model
	 * @return
	 * @since 0.0.4
	 */
	@PostMapping("/delete")
	public ModelAndView deleteMarket(Market market, ModelMap model) {
		marketSvc.remove(market);
				
		return new ModelAndView("redirect:/liquid/markets", model);
	}
	
	/*
	 * 
	 * @param updDTO
	 * @param model
	 * @return
	 * @since 0.0.5
	 
	@PostMapping("/update")
	public ModelAndView updateAsset(@ModelAttribute("updDTO") MarketUpdateDTO updDTO, ModelMap model) {
		marketSvc.update(updDTO.from, updDTO.to);
				
		return new ModelAndView("redirect:/liquid/markets", model);
	}
	*/
}
