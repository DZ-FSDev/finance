package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder.LiquidOrder;
import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition.Position;

/**
 * Persistence layer for Liquid Account entities.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.5
 */
public interface IAccountRepository extends JpaRepository<Account, Long> {
	/*
	 *  -- Read --
	 */
	public Optional<Account> findByName(String name);
	
	public List<Position> findPositionsByName(String name);
	
	public List<LiquidOrder> findOrdersByName(String name);
	
	public <T> List<T> findFirst3ByOrderByRealizedPNL(Class<T> type);
	public <T> List<T> findFirst5ByOrderByRealizedPNL(Class<T> type);
	public <T> List<T> findFirst10ByOrderByRealizedPNL(Class<T> type);
	public <T> List<T> findFirst100ByOrderByRealizedPNL(Class<T> type);
	
	/*
	 *  -- Delete --
	 */
	public long deleteByName(String name);
}
