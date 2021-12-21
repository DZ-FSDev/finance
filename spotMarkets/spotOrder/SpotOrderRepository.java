package com.dz_fs_dev.finance.spotMarkets.spotOrder;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Spot SpotOrder entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotOrderRepository extends JpaRepository<SpotOrder, Long>{
	Optional<SpotOrder> findByOrderId(Long id);
}
