/*  Original Licensing Copyright
 * 
 *  v1/liquid/assets REST Service Controller.
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
package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * v1/liquid/assets REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.7
 */
@RestController
@RequestMapping("/v1/liquid/assets")
public class RESTController_v1_liquid_assets {
	@Autowired
	IAssetService assetSvc;
	
	@GetMapping(value = "/list")
	public Flux<DTOAsset> getAllAssets(){
		return assetSvc.getAllAssets();
	}
	
	@PostMapping(value = "/add")
	public Mono<DTOAsset> addAsset(@RequestBody DTOAsset asset){
		return assetSvc.add(asset);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @since 0.0.6
	 */
	@GetMapping(value = "/{id}")
	public Mono<DTOAsset> findById(@PathVariable Long id){
		return assetSvc.findById(DTOAsset.class, id);
	}
}
