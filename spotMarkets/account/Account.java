package com.dz_fs_dev.finance.spotMarkets.account;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dz_fs_dev.finance.spotMarkets.position.Position;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain Object representing an Account in spot markets.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
@Entity
@ToString
@EqualsAndHashCode
public class SpotAccount implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -2480756664415763406L;

	private @Getter @Setter @Id @GeneratedValue Long AccountId;
	
	private @Getter @Setter @ElementCollection Set<Position> positions;
}
