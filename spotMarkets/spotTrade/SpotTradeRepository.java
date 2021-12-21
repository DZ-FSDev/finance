package com.dz_fs_dev.finance.spotMarkets.spotTrade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for SpotTrade entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotTradeRepository extends JpaRepository<SpotTrade, Long>{
	Optional<SpotTrade> findByTradeId(Long id);
}
