package de.awacademy.fitglow.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Tresor {

	private SecretKeySpec secretKeySpec;
	private byte[] key;

	private void generateKey(String myKey) {
		MessageDigest messageDigest = null;
		try {
			key = myKey.getBytes("UTF-8");
			messageDigest = MessageDigest.getInstance("SHA-1");
			key = messageDigest.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKeySpec = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String strToEncrypt, String secret) {
		try {
			generateKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public String decrypt(String secret) {
		try {
			generateKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			return new String(cipher.doFinal(Base64.getDecoder().decode("z6dFRBCH6AfNZRY3sFXYwg==")));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public String bill(String secret) {
		try {
			generateKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			return new String(cipher.doFinal(Base64.getDecoder().decode("FmN+YYtPt0UskGSOJ+saHw==")));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

}