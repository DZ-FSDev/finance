package com.dz_fs_dev.finance.domain.spotMarkets;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object for basic Candlesticks on Spot Markets
 * 
 * @author DZ-FSDev
 * @since 15
 * @version 0.1
 */
@Entity
public class SpotCandlestick implements Serializable{
	private static final long serialVersionUID = 3048151457044300946L;
	
	private @Getter @Setter @Id @GeneratedValue long id;
	
	private @Getter @Setter BigDecimal open;
	private @Getter @Setter BigDecimal close;
	private @Getter @Setter BigDecimal high;
	private @Getter @Setter BigDecimal low;
	private @Getter @Setter BigDecimal quoteVolume;
	private @Getter @Setter BigInteger assetVolume;

	private @Getter @Setter Long startTimeStamp;
	private @Getter @Setter Long endTimeStamp;
	
	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY) @JsonIgnore List<SpotTrade> executedTrades;

	/**
	 * Zero-arg constructor for SpotCandlestick
	 */
	public SpotCandlestick() {}
	
	/**
	 * Constructs a new SpotCandlestick that should follow a previously closed candlestick
	 * 
	 * @param prev The previous candlestick to grab the start time and price to open the new candlestick
	 */
	public SpotCandlestick(SpotCandlestick prev) {
		setStartTimeStamp(prev.getEndTimeStamp());
		setClose(prev.getClose());
		setOpen(getClose());
		setHigh(getClose());
		setLow(getClose());
	}
	
	/**
	 * Registers a Spot Trade to the candle. Fails if trade falls outside the time range of the current candle by throwing a TradeException.
	 * 
	 * @param trade The Spot Trade to be registered to the candle.
	 * @throws TradeException Exception when trade registration was unsuccessful.
	 */
	public void registerTrade(SpotTrade trade) throws TradeException {
		if(trade.getTransactTime() > startTimeStamp && endTimeStamp != 0 && trade.getTransactTime() < endTimeStamp)
			throw new TradeException("Failed to Register Trade " + trade.getTradeId() + " - registration out of current candle time stamp range.");
		
		setClose(trade.getMaker().getQuote());
		if(getLow().compareTo(getClose()) > 0)setLow(getClose());
		if(getHigh().compareTo(getClose()) < 0)setHigh(getClose());
		setAssetVolume(getAssetVolume().add(trade.getTransactedAssetVolume()));
		setQuoteVolume(getQuoteVolume().add(trade.getMaker().getQuote().multiply(new BigDecimal(trade.getTransactedAssetVolume()))));
		
		if(executedTrades == null)executedTrades = new ArrayList<SpotTrade>();
		executedTrades.add(trade);
	}
	
	/**
	 * Closes the current candle. All subsequent trade registrations will fail on this candle.
	 */
	public void closeCandle() {
		setEndTimeStamp(System.currentTimeMillis());
	}
	
	@Override
	public int hashCode() {
		final int prime = 171731;
		int result = 1;
		result = prime * result + ((assetVolume == null) ? 0 : assetVolume.hashCode());
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((endTimeStamp == null) ? 0 : endTimeStamp.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((quoteVolume == null) ? 0 : quoteVolume.hashCode());
		result = prime * result + ((startTimeStamp == null) ? 0 : startTimeStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SpotCandlestick))
			return false;
		SpotCandlestick other = (SpotCandlestick) obj;
		if (assetVolume == null) {
			if (other.assetVolume != null)
				return false;
		} else if (!assetVolume.equals(other.assetVolume))
			return false;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (endTimeStamp == null) {
			if (other.endTimeStamp != null)
				return false;
		} else if (!endTimeStamp.equals(other.endTimeStamp))
			return false;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
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
		if (quoteVolume == null) {
			if (other.quoteVolume != null)
				return false;
		} else if (!quoteVolume.equals(other.quoteVolume))
			return false;
		if (startTimeStamp == null) {
			if (other.startTimeStamp != null)
				return false;
		} else if (!startTimeStamp.equals(other.startTimeStamp))
			return false;
		return true;
	}
	
	static SpotCandlestick fromJSON(String jStr) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jStr.toString(), SpotCandlestick.class);
	}
	
	static Optional<String> toJSONstr(SpotCandlestick a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return Optional.ofNullable(mapper.writeValueAsString(a));
	}
}
