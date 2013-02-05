package com.cmq.module.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Utils {

	public static String md5(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md.digest(source.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
