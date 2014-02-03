package com.jiunes.music.client.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class Main {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		MusicClient musicClient = new MusicClient("localhost",8888);
		Response response = musicClient.get("/music_player/user");
		System.out.println(response.getStatusCode());
		System.out.println(response.getResponse());
	}
}
