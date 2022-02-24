package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Entity
public class Account implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 8539911094908576689L;

	private @Getter @Setter @Id @GeneratedValue Long accountId;
	
}
