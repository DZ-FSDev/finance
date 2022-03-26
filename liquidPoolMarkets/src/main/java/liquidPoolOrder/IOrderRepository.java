package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * Persistence layer for Liquid Order entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public interface IOrderRepository extends R2dbcRepository<LiquidOrder, Long>{
	/*
	 *  -- Read --
	 */
	
	/*
	 *  -- Update --
	 */
}
