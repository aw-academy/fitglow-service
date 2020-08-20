package de.awacademy.fitglow.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TresorTest {

	@Test
	public void init() {
		Tresor aes = new Tresor();
		assertNotNull(aes);
	}
	
}
