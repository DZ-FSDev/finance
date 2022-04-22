package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolTrade;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Trade executed in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@Data
@Table("trade")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOTrade implements ITrade{
	private @Id Long id;
	
	private Long ts;
	private String units;
	private String allowableCostBasis;
	
	private Long marketId;
	private Long accountId;
}
