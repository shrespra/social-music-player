package com.jiunes.music.client.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;

public class Response {
	private final int statusCode;
	private final String response;

	Response(int statusCode, String response) {
		this.statusCode = statusCode;
		this.response = response;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getResponse() {
		return response;
	}

	public static Response from(HttpResponse response) {
		try {
			return new Response(response.getStatusLine().getStatusCode(), toString(response.getEntity().getContent()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String toString(InputStream content) {
		Scanner sc = new Scanner(content);
		sc.useDelimiter("\\Z+");
		return sc.next();
	}

}
