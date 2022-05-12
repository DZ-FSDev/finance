package com.dz_fs_dev.finance.analytics;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

/**
 * 
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public final class Levels {
	private Levels() {}
	
	@AllArgsConstructor
	public static enum Fib{
		p5(new BigDecimal("0.5"));

		final BigDecimal fib;
	}
	
}
