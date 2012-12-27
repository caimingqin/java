package com.cmq.module.http;

import java.io.FileInputStream;
import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

import com.cmq.module.util.JsonParser;

public class ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7914040471819725902L;
	private String statusCode;
	private String message;
	private Object contents;
	private String sessionId;
	private String contentsType;

	public ResponseMessage() {
	}

	public ResponseMessage(String statusCode, String message, Object contents, String sessionId, String contentsType) {
		this.statusCode = statusCode;
		this.message = message;
		this.contents = contents;
		this.sessionId = sessionId;
		this.contentsType = contentsType;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public Object getContents() {
		return contents;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getContentsType() {
		return contentsType;
	}

	public String contentsToJson() {
		return JsonParser.encode(this.contents);
	}

	public void autoTest() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:/survey.txt");
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseMessage readValue = objectMapper.readValue(fileInputStream, ResponseMessage.class);
		System.out.println(readValue.getStatusCode());
		Object contents = readValue.getContents();
		System.out.println(contents.toString());
		System.out.println(JsonParser.encode(contents));

	}
}
