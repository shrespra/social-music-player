package com.jiunes.music.client.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class UserGet {
		public static void main(String[] args) throws ClientProtocolException, IOException {
	
		HttpTransportClient httpClient = new HttpTransportClient("localhost",8888);
		Response response = httpClient.get("/music_player/user");
		System.out.println(response.getStatusCode());
		System.out.println(response.getResponse());
	}
}
