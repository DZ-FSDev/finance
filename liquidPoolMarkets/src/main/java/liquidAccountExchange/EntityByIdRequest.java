package com.dz_fs_dev.finance.liquidPoolMarkets.liquidAccountExchange;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the various entities which need to be retrieved by id from the
 * persistence layer.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
@Data
@AllArgsConstructor
public class EntityByIdRequest {
	private Long id;
	Class<?> type;
}
