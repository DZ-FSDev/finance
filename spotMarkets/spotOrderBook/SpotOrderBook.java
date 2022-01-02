package com.dz_fs_dev.finance.spotMarkets.spotOrderBook;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dz_fs_dev.finance.spotMarkets.spotOrder.SpotOrder;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing a spot order book.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Entity
public class SpotOrderBook implements Serializable {
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -4764569976383960818L;
	
	public @Getter @Setter @GeneratedValue @Id Long orderBookId;
	
	public @Getter @Setter BigDecimal lprice;
	public @Getter @Setter BigDecimal mprice;
	public @Getter @Setter BigDecimal tickSize;
	
	LinkedList<SpotOrder>[] orders;
}
