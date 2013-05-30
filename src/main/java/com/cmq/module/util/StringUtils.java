package com.cmq.module.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class StringUtils {

	public static String buildStringFromInputStream(InputStream in) {
		try {
			byte[] buffer = new byte[in.available()];
			while (in.read() != -1) {
				in.read(buffer);
			}
			return new String(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Test
	public void test() throws UnsupportedEncodingException{
		
		String a="中文";
//				%C3%A4%C2%B8%C2%AD%C3%A6%C2%96%C2%87.pdf 
		System.out.println(new String(a.getBytes(), "UTF-8"));	
		
		System.out.println(new String(a.getBytes(), "ISO-8859-1"));		
	}
}
