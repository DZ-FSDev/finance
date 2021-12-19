package com.dz_fs_dev.finance.spotMarkets.spotCandlestick;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dz_fs_dev.finance.futuresMarkets.exception.TradeException;
import com.dz_fs_dev.finance.spotMarkets.exception.CandleClosedException;
import com.dz_fs_dev.finance.spotMarkets.spotTrade.SpotTrade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object for basic Candlesticks on Spot Markets
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
@Entity
public class SpotCandlestick implements Serializable{
	/**
	 * @since 0.0.3
	 */
	private static final long serialVersionUID = 3699032142603754246L;

	private @Getter @Setter @Id @GeneratedValue Long id;
	
	private @Getter @Setter BigDecimal askOpen;
	private @Getter @Setter BigDecimal bidOpen;
	private @Getter @Setter BigDecimal askClose;
	private @Getter @Setter BigDecimal bidClose;
	private @Getter @Setter BigDecimal open;
	private @Getter @Setter BigDecimal high;
	private @Getter @Setter BigDecimal low;
	private @Getter @Setter BigDecimal close;
	private @Getter @Setter BigDecimal quoteVolume;
	private @Getter @Setter BigDecimal assetVolume;

	private @Getter @Setter Long openTimeStamp;
	private @Getter @Setter Long closeTimeStamp;
	
	@ElementCollection(targetClass=SpotTrade.class)
	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY) @JsonIgnore List<SpotTrade> executedTrades;

	/**
	 * Default constructor for SpotCandlestick.
	 */
	public SpotCandlestick() {}
	
	/**
	 * Constructs a new SpotCandlestick that should follow a previously closed candlestick.
	 * 
	 * @param prev The previous candlestick to grab the start time and price to open the new candlestick.
	 * @since 0.0.2
	 */
	public SpotCandlestick(SpotCandlestick prev) {
		setOpenTimeStamp(prev.getCloseTimeStamp());
		setAskClose(prev.getAskClose());
		setBidClose(prev.getBidClose());
		setAskOpen(getAskClose());
		setBidOpen(getBidClose());
		setHigh(getAskClose());
		setLow(getBidClose());
	}
	
	/**
	 * Registers a Spot Trade to the candle. Fails if trade falls outside the time range of the current candle by throwing a TradeException.
	 * 
	 * @param trade The Spot Trade to be registered to the candle.
	 * @throws TradeException Exception when trade registration was unsuccessful.
	 * @since 0.0.3
	 */
	public void registerTrade(SpotTrade trade) throws TradeException {
		if(trade.getTransactTime() > openTimeStamp && closeTimeStamp != 0 && trade.getTransactTime() < closeTimeStamp)
			throw new TradeException("Failed to Register Trade " + trade.getTradeId() + " - registration out of current candle time stamp range.");
		
		setBidClose(trade.getMaker().getQuote());
		if(getLow().compareTo(getAskClose()) > 0)setLow(getAskClose());
		if(getHigh().compareTo(getAskClose()) < 0)setHigh(getAskClose());
		setAssetVolume(getAssetVolume().add(trade.getTransactedAssetVolume()));
		setQuoteVolume(getQuoteVolume().add(trade.getMaker().getQuote().multiply(trade.getTransactedAssetVolume())));
		
		if(executedTrades == null)executedTrades = new ArrayList<SpotTrade>();
		executedTrades.add(trade);
	}
	
	/**
	 * Closes the current candle. All subsequent trade registrations will fail on this candle.
	 * 
	 * @throws CandleClosedException Thrown if candle is already closed.
	 * @since 0.0.2
	 */
	public void closeCandle() throws CandleClosedException {
		if(getCloseTimeStamp() != null && !getCloseTimeStamp().equals(Long.valueOf(0)))throw new CandleClosedException("Candle " + getId() + " is already closed.");
		setCloseTimeStamp(System.currentTimeMillis());
	}
	
	/**
	 * @since 0.0.3
	 */
	@Override
	public int hashCode() {
		final int prime = 171731;
		int result = 1;
		result = prime * result + ((askClose == null) ? 0 : askClose.hashCode());
		result = prime * result + ((askOpen == null) ? 0 : askOpen.hashCode());
		result = prime * result + ((assetVolume == null) ? 0 : assetVolume.hashCode());
		result = prime * result + ((bidClose == null) ? 0 : bidClose.hashCode());
		result = prime * result + ((bidOpen == null) ? 0 : bidOpen.hashCode());
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((closeTimeStamp == null) ? 0 : closeTimeStamp.hashCode());
		result = prime * result + ((executedTrades == null) ? 0 : executedTrades.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((openTimeStamp == null) ? 0 : openTimeStamp.hashCode());
		result = prime * result + ((quoteVolume == null) ? 0 : quoteVolume.hashCode());
		return result;
	}

	/**
	 * @since 0.0.3
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotCandlestick))
			return false;
		SpotCandlestick other = (SpotCandlestick) obj;
		if (askClose == null) {
			if (other.askClose != null)
				return false;
		} else if (!askClose.equals(other.askClose))
			return false;
		if (askOpen == null) {
			if (other.askOpen != null)
				return false;
		} else if (!askOpen.equals(other.askOpen))
			return false;
		if (assetVolume == null) {
			if (other.assetVolume != null)
				return false;
		} else if (!assetVolume.equals(other.assetVolume))
			return false;
		if (bidClose == null) {
			if (other.bidClose != null)
				return false;
		} else if (!bidClose.equals(other.bidClose))
			return false;
		if (bidOpen == null) {
			if (other.bidOpen != null)
				return false;
		} else if (!bidOpen.equals(other.bidOpen))
			return false;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (closeTimeStamp == null) {
			if (other.closeTimeStamp != null)
				return false;
		} else if (!closeTimeStamp.equals(other.closeTimeStamp))
			return false;
		if (executedTrades == null) {
			if (other.executedTrades != null)
				return false;
		} else if (!executedTrades.equals(other.executedTrades))
			return false;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (low == null) {
			if (other.low != null)
				return false;
		} else if (!low.equals(other.low))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (openTimeStamp == null) {
			if (other.openTimeStamp != null)
				return false;
		} else if (!openTimeStamp.equals(other.openTimeStamp))
			return false;
		if (quoteVolume == null) {
			if (other.quoteVolume != null)
				return false;
		} else if (!quoteVolume.equals(other.quoteVolume))
			return false;
		return true;
	}
}
