package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition.Position;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.5
 */
@Entity
public class Account implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = 8539911094908576689L;

	private @Getter @Setter @Id @GeneratedValue Long id;
	
	private @Getter @Setter @Id @GeneratedValue String name;
	
	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY) List<Position> positions;
	
	private @Getter @Setter @Transient BigDecimal unrealizedPNL;
	private @Getter @Setter BigDecimal realizedPNL;
}
