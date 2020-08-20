package de.awacademy.fitglow.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TipMapperTest {

	@Test
	public void fetchTip_Waitor() {
		TipMapper tipMapper = new TipMapper();
		BigDecimal tip = tipMapper.fetchTip(TipCategory.WAITER, new BigDecimal("250")); 
		assertEquals("50", tip.toString());
	}
	
	@Test
	public void fetchTip_Kitchen() {
		TipMapper tipMapper = new TipMapper();
		BigDecimal tip = tipMapper.fetchTip(TipCategory.KITCHEN, new BigDecimal("250")); 
		assertEquals("37", tip.toString());
	}
	
	@Test
	public void fetchTip_Bouncer() {
		TipMapper tipMapper = new TipMapper();
		BigDecimal tip = tipMapper.fetchTip(TipCategory.BOUNCER, new BigDecimal("250")); 
		assertEquals("25", tip.toString());
	}
	
	
}
