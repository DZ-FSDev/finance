package com.dz_fs_dev.finance.liquidPoolMarkets.liquidAccountExchange;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a failed request token containing a message.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class TokenRequestFailEntity {
	String message;
}
