package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements IAccount{
	private @Id Long id;
	
	private String name;
	private @Transient BigDecimal unrealizedPNL;
	private BigDecimal realizedPNL;
}
