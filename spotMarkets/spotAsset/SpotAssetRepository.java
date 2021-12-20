package com.dz_fs_dev.finance.spotMarkets.spotAsset;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Spot SpotAsset entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotAssetRepository extends JpaRepository<SpotAsset, Long>{
	Optional<SpotAsset> findByName(String name);
	Optional<SpotAsset> findBySymbol(String symbol);
}
