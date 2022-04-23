package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import org.springframework.data.annotation.Id;
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
 * @version 0.0.2
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOPositionRight implements IPosition{
	private @Id Long id;

	private String units;
	private String lockedUnits;

	private @Transient String unrealizedPNL;

	private Long accountId;
	private Long assetId;

	/**
	 * 
	 * @return
	 * @since 0.0.2
	 */
	public DTOPosition toDTOPosition() {
		return DTOPosition.builder()
				.id(id)
				.units(units)
				.lockedUnits(lockedUnits)
				.accountId(accountId)
				.assetId(assetId)
				.build();
	}
}
