package com.dz_fs_dev.finance.spotMarkets.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dz_fs_dev.finance.spotMarkets.domain.SpotCandlestick;

/**
 * Persistence layer for Spot Candlestick entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
public interface SpotCandlestickRepository extends JpaRepository<SpotCandlestick, Long>{
	Optional<SpotCandlestick> findByClose(BigDecimal close);
	Optional<SpotCandlestick> findByOpen(BigDecimal close);
	Optional<SpotCandlestick> findByHigh(BigDecimal close);
	Optional<SpotCandlestick> findByLow(BigDecimal close);

	Optional<SpotCandlestick> findByOpenTimeStampBetween(Long begin, Long end);
	Optional<SpotCandlestick> findByCloseTimeStampBetween(Long begin, Long end);
}
