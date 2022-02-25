/*  Original Licensing Copyright
 * 
 *  liquid/markets WEB Service Controller.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * liquid/markets WEB Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.2
 * @version 0.0.10
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

	/**
	 * 
	 * @param model
	 * @return
	 * @since 0.0.7
	 */
	@GetMapping("/priceMatrix")
	public String getPriceMatrix(Model model) {
		model.addAttribute("matrix", MarketPriceMatrixDTO.cachedInstance);

		return "/liquid/markets/priceMatrix";
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @since 0.0.8
	 */
	@GetMapping("/chart/{ticker}")
	public String getChart(@PathVariable String ticker, Model model) {
		model.addAttribute("ticker", ticker);

		return "/liquid/markets/chart";
	}

	/**
	 * 
	 * @param ticker
	 * @param response
	 * @since 0.0.10
	 */
	@GetMapping(value = "/chartcsv/{ticker}")
	@ResponseBody
	public void getChartCSV(@PathVariable String ticker, HttpServletResponse response){
		response.setContentType("text/csv");
		try (Writer writer = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8)) {
			writer.write(marketSvc.getChartCSV(ticker));
			writer.flush();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
