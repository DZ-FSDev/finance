package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

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
 * @version 0.0.4
 */
@Table("position")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOPosition implements IPosition{
	private @Id Long id;

	private String cumulativeUnits;
	private String units;
	private String lockedUnits;

	private String costBasis;
	private @Transient String unrealizedPNL;
	private String realizedPNL;
	
	private Long basisCurrencyId;
	private Long accountId;
	private Long assetId;
}
