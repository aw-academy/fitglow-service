package de.awacademy.fitglow.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class TipMapper {
	
	private final Map<TipCategory, BigDecimal> tipMap = new HashMap<TipCategory, BigDecimal>();
	
	public TipMapper() {
		tipMap.put(TipCategory.WAITER, new BigDecimal("0.20")); // Waiters get 20% tip
		tipMap.put(TipCategory.KITCHEN, new BigDecimal("0.15")); // Kitchen staff get 15% tip
		tipMap.put(TipCategory.BOUNCER, new BigDecimal("0.10")); // Bouncer get 10% tip
	}
	
	
	public BigDecimal fetchTip(TipCategory position, BigDecimal bill) {
		BigDecimal rate = tipMap.get(position);
		
		BigDecimal result = bill.multiply(rate).setScale(0, RoundingMode.FLOOR);
		
		return result;
	}
	
}
