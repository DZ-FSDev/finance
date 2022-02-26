package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Liquid Account entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.2
 */
public interface IAccountRepository extends JpaRepository<Account, Long> {
	/*
	 *  -- Read --
	 */
	public Optional<Account> findByName(String name);
	
	/*
	 *  -- Delete --
	 */
	public long deleteByName(String name);
}
