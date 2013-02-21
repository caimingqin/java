package com.cmq.module.excel;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {
	
	private static Log logger = LogFactory.getLog(ExcelParser.class.getName());
	public static Workbook parse(InputStream in, ExcelType excelType) {
		Workbook wb = null;
		try {
			if (excelType.equals(ExcelType.XLS)) {
				wb = new HSSFWorkbook(in);
			} else {
				wb = new XSSFWorkbook(in);
			}
		} catch (IOException e) {
			logger.info("create Workbook Exception "+e.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				logger.info("close IO Exception "+e.getMessage());
			}
		}
		return wb;
	}

	public enum ExcelType {
		XLS, XLSX
	}
}
