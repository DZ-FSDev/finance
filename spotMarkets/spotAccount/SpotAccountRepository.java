package com.dz_fs_dev.finance.spotMarkets.spotAccount;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for SpotAccount entities.
 * 
 * @author DZ-FSDev
 * @version 0.0.2
 * @since 17.0.1
 */
public interface SpotAccountRepository extends JpaRepository<SpotAccount, Long>{
	Optional<SpotAccount> findByUsername(String username);
	Optional<SpotAccount> findByNickname(String nickname);
}
