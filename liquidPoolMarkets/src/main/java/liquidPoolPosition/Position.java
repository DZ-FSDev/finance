package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a liquid pool position.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.9
 */
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position implements IPosition{
	private @Id Long id;

	private BigInteger cumulativeUnits;
	private BigInteger units;

	private BigInteger costBasis;
	private @Transient BigDecimal unrealizedPNL;
	private BigDecimal realizedPNL;
	
	private Long basisCurrencyId;
	private Long accountId;
}
