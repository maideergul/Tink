package com.works.usetink.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws Exception {

		
	/*	String Key128Bit = "RgUkXn2r5u8x/A?D";
		String plainText = "123;ali@ali.com;true";
		String associatedData = "extra_key";
		//String ciphertext = "`ò`íï±Ivm®.¬¾6-6Ü¹¶µÝvS[[Z(òÁÃ9pjãzvZ";

		TinkEncrypt create  = new TinkEncrypt();
		String encString = create.encrypt(Key128Bit, plainText, associatedData);
		System.out.println(encString);
		
		File file = new File("sample.txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(encString);
		
		fileWriter.close(); */
		
		
		String Key128Bit = "RgUkXn2r5u8x/A?D";		
		String associatedData = "extra_key";

		File file = new File("sample.txt");
		Scanner scanner = new Scanner(file);
		StringBuilder builder = new StringBuilder();
		while(scanner.hasNext())
		{
			builder.append(scanner.nextLine());
		}
		
		
		TinkDecryption decryption  = new TinkDecryption();
		String decryptString = decryption.decrypt(Key128Bit, builder.toString(), associatedData);
		System.out.println(decryptString); 

	}

}
