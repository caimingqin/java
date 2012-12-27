package com.cmq.module.util;

import java.io.IOException;
import java.io.InputStream;

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
}
