package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@Data
@Table("Account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTOAccount implements IAccount{
	private @Id Long id;
	
	private String firstName;
	private String lastName;
	private @Transient String unrealizedPNL;
	private String realizedPNL;
}
