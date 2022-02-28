package com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolAccount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolOrder.LiquidOrder;
import com.dz_fs_dev.finance.liquidPoolMarkets.liquidPoolPosition.Position;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Account in liquid pool markets.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.8
 */
@Entity
public class Account implements Serializable{
	/**
	 * @since 0.0.8
	 */
	private static final long serialVersionUID = 5297782569320841422L;

	private @Getter @Setter @Id @GeneratedValue Long id;
	
	private @Getter @Setter String name;
	
	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY, mappedBy = "account") List<Position> positions;

	private @Getter @Setter @OneToMany(fetch = FetchType.LAZY, mappedBy = "account") List<LiquidOrder> orders;
	
	private @Getter @Setter @Transient BigDecimal unrealizedPNL;
	private @Getter @Setter BigDecimal realizedPNL;
	
	/**
	 * @since 0.0.8
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
		result = prime * result + ((realizedPNL == null) ? 0 : realizedPNL.hashCode());
		result = prime * result + ((unrealizedPNL == null) ? 0 : unrealizedPNL.hashCode());
		return result;
	}
	
	/**
	 * @since 0.0.8
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
			return false;
		if (realizedPNL == null) {
			if (other.realizedPNL != null)
				return false;
		} else if (!realizedPNL.equals(other.realizedPNL))
			return false;
		if (unrealizedPNL == null) {
			if (other.unrealizedPNL != null)
				return false;
		} else if (!unrealizedPNL.equals(other.unrealizedPNL))
			return false;
		return true;
	}

	/**
	 * @since 0.0.8
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", positions=" + positions + ", orders=" + orders
				+ ", unrealizedPNL=" + unrealizedPNL + ", realizedPNL=" + realizedPNL + "]";
	}
	
	
}
