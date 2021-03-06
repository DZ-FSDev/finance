package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Transient;
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
 * @version 0.0.13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position implements IPosition{
	private Long id;

	private BigInteger cumulativeUnits;
	private BigInteger units;
	private BigInteger lockedUnits;

	private BigInteger costBasis;
	private @Transient BigDecimal unrealizedPNL;
	private BigDecimal realizedPNL;
	
	private Long basisCurrencyId;
	private Long accountId;
	private Long assetId;
}
