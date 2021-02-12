package com.works.usetink.utils;

import com.google.crypto.tink.subtle.AesGcmJce;

public class TinkEncrypt {
	
	
	public static String encrypt( String key128Bit, String plainText, String associatedData ) {
		
		String stringEncrypt = "";
		try {
			
			AesGcmJce aesGcmJce = new AesGcmJce(key128Bit.getBytes());
			byte[] encryptBytes = aesGcmJce.encrypt(plainText.getBytes(), associatedData.getBytes());
			stringEncrypt = new String(encryptBytes, "ISO-8859-1");
			
		} catch (Exception e) {
			System.err.println("Encrypt Err : " + e);
		}
		
		return stringEncrypt;
	}

}