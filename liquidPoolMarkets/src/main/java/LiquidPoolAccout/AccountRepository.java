package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Persistence layer for Liquid Account entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}
