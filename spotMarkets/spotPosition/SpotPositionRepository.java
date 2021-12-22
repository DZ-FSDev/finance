package com.dz_fs_dev.finance.spotMarkets.spotPosition;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for SpotPosition entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotPositionRepository extends JpaRepository<SpotPosition, Long>{
	Optional<SpotPosition> findByPositionId(Long positionId);
}
