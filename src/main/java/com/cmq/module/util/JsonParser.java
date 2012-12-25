package com.cmq.module.util;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonParser {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String encode(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public static <T> T decode(String content, Class<T> clazzs) {
		try {
			return objectMapper.readValue(content, clazzs);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public static <T> T decode(String content, TypeReference<T> typeReference) {
		try {
			return objectMapper.readValue(content, typeReference);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public static <T> T decode(InputStream in, Class<T> clazzs) {
		try {
			return objectMapper.readValue(in, clazzs);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}
}
