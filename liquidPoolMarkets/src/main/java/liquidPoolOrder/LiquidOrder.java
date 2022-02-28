package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount.Account;
import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAsset.Asset;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Order placed in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.4
 */
@Entity
public class LiquidOrder implements Serializable{
	/**
	 * @since 0.0.3
	 */
	private static final long serialVersionUID = -2414199150565231642L;

	private @Getter @Setter @GeneratedValue @Id Long id;
	
	private @Getter @Setter Long timestamp;
	
	private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY) Asset asset;
	private @Getter @Setter BigInteger units;
	private @Getter @Setter BigInteger allowableCostBasis;
	
	private @Getter @Setter @JsonIgnore @ManyToOne(fetch = FetchType.LAZY) Account account;
}
