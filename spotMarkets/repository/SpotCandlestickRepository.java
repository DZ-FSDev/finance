package com.dz_fs_dev.finance.spotMarkets.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dz_fs_dev.finance.spotMarkets.domain.SpotCandlestick;

/**
 * Persistence layer for Spot Candlestick entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 16.0.1
 */
public interface SpotCandlestickRepository extends JpaRepository<SpotCandlestick, Long>{
	Optional<SpotCandlestick> findByClose(BigInteger close);
}
