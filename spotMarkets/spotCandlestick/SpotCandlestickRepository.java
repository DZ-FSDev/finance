package com.dz_fs_dev.finance.spotMarkets.spotCandlestick;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Spot Candlestick entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.3
 * @since 17.0.1
 */
public interface SpotCandlestickRepository extends JpaRepository<SpotCandlestick, Long>{
	Optional<SpotCandlestick> findByClose(BigDecimal close);
	Optional<SpotCandlestick> findByOpen(BigDecimal close);
	Optional<SpotCandlestick> findByHigh(BigDecimal close);
	Optional<SpotCandlestick> findByLow(BigDecimal close);

	Optional<SpotCandlestick> findByOpenTimeStampBetween(Long begin, Long end);
	Optional<SpotCandlestick> findByCloseTimeStampBetween(Long begin, Long end);
	
	<T> T findByOpenTimeStampBetween(Long begin, Long end, Class<T> type);
	<T> T findByCloseTimeStampBetween(Long begin, Long end, Class<T> type);
}
