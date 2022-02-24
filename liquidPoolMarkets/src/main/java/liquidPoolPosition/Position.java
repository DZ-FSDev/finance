package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount.Account;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a liquid pool position.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Entity
public class Position implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -1046468471511570027L;
	
	private @Getter @Setter @GeneratedValue @Id Long positionId;
	
	private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY, optional = false) Account account;
	
	private @Getter @Setter BigDecimal costBasis;
}
