package com.dz_fs_dev.finance.spotMarkets.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for SpotAccount entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 17.0.1
 */
public interface SpotAccountRepository extends JpaRepository<SpotAccount, Long>{
	Optional<SpotAccount> findByName(String quote);
}
