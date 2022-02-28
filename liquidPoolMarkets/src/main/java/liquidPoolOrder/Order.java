package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount.Account;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Order placed in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
@Entity
public class Order {
	private @Getter @Setter @GeneratedValue @Id Long id;
	
	private @Getter @Setter Long timestamp;
	
	private @Getter @Setter BigInteger units;
	
	private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY) Account account;
}
