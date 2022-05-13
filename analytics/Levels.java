package com.dz_fs_dev.finance.analytics;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

/**
 * Utility class providing functionality for calculating different price
 * levels.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public final class Levels {
	private Levels() {}
	
	@AllArgsConstructor
	public static enum Fib{
		p5(new BigDecimal("0.5"));

		final BigDecimal fib;
		
		/**
		 * 
		 * @param price
		 * @return
		 */
		BigDecimal apply(BigDecimal price){
			return price.multiply(fib);
		}
		
		/**
		 * 
		 * @param support
		 * @param resistance
		 * @return
		 */
		BigDecimal apply(BigDecimal support, BigDecimal resistance){
			BigDecimal delta = resistance.subtract(support);
			return support.add(delta.multiply(fib));
		}
	}
}
