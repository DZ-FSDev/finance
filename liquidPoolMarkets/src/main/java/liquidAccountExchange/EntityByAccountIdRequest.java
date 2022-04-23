package com.dz_fs_dev.finance.liquidPoolMarkets.liquidAccountExchange;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the various entities which need to be retrieved by account id
 * from the persistence layer.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class EntityByAccountIdRequest {
	Class<?> type;
	private Long id;
}
