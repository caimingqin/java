package com.cmq.module.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class IOParser {
	private static final Log logger = LogFactory.getLog(IOParser.class
			.getName());

	public List<String> readLine(InputStream in) {
		if (in == null) {
			return null;
		}
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		List<String> results = new ArrayList<String>();
		try {
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
				results.add(str);
			}
		} catch (IOException e) {
			logger.error("IOParser readLine error" + e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				logger.error("IOParser IO close error" + e.getMessage());
			}
		}
		logger.debug("readLine result size " + results.size());
		return results;
	}

	public static Properties buildProperties(InputStream inputStream) {
		Properties pros = new Properties();
		try {
			pros.load(inputStream);
			logger.info(pros.getProperty("host") + ","
					+ pros.getProperty("port"));
			return pros;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Test
	public void test() {

		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("readLine.txt");
		List<String> emps = readLine(inputStream);
		System.out.println(emps.size());

	}

	@Test
	public void testPro() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("mongo.properties");
		buildProperties(inputStream);
	}
}
