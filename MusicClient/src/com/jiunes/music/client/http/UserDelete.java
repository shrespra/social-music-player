package com.jiunes.music.client.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class UserDelete {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpTransportClient httpClient = new HttpTransportClient("localhost",8888);
		Response response = httpClient.delete("/music_player/user/4573968371548160");
		System.out.println(response.getStatusCode());
		System.out.println(response.getResponse());
	}
}
