package com.cmq.module.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.cmq.module.util.JsonParser;

public class AppContext {
	public static String command(String params) {

		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://1.232.123.197:9000/komaa/commandHandler.shtml");
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("qcmd", params));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			System.out.println("=========start");
			HttpResponse httpResponse = client.execute(httpPost);
			System.out.println("=========end" + httpResponse.getStatusLine().getStatusCode());
			HttpEntity entity = httpResponse.getEntity();
			String jsonContents = JsonParser.encode(entity.getContent());
			return jsonContents;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
