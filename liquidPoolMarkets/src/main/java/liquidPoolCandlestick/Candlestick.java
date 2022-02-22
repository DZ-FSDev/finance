package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolCandlestick;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolMarket.Market;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a candlestick in a liquid pool market.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Entity
public class Candlestick implements Serializable{
	/**
	 * @since 0.0.1
	 */
	private static final long serialVersionUID = -3009495938733440731L;
	
	private @Getter @Setter @Id @GeneratedValue Long candlestickId;
	
	private @Getter @Setter Long openTimestamp;
	private @Getter @Setter Long closeTimestamp;
	
	private @Getter @Setter BigDecimal open;
	private @Getter @Setter BigDecimal close;
	private @Getter @Setter BigDecimal high;
	private @Getter @Setter BigDecimal low;
	
	private @Getter @Setter BigDecimal assetVolume;
	private @Getter @Setter BigDecimal quoteVolume;
	
	private @Getter @Setter @JsonIgnore @ManyToOne(fetch = FetchType.LAZY, optional = false) Market market;
}
