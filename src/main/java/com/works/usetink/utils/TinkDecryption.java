package com.works.usetink.utils;

import com.google.crypto.tink.subtle.AesGcmJce;

public class TinkDecryption {
	
	public static String decrypt( String key128Bit, String ciphertext, String associatedData)
	{
		String decString = "";
		try {
			
			byte[] converEncodeBytes = ciphertext.getBytes("ISO-8859-1");
			AesGcmJce aesGcmJce = new AesGcmJce(key128Bit.getBytes());
			byte[] decryptBytes = aesGcmJce.decrypt(converEncodeBytes, associatedData.getBytes());
			decString = new String(decryptBytes);
			
		} catch (Exception e) {
			System.err.println("Decrypt Err : " + e);
		}
		
		return decString;
	}

}