package de.awacademy.fitglow.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdvancedEncryptionStandardTest {

	@Test
	public void init() {
		AdvancedEncryptionStandard aes = new AdvancedEncryptionStandard();
		assertNotNull(aes);
	}
	
}
