package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Order placed in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@Data
@Table("liquidOrder")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOLiquidOrder implements ILiquidOrder{
	private @Id Long id;
	
	private Long ts;
	private String units;
	private String allowableCostBasis;
	
	private Long assetId;
	private Long accountId;
}
