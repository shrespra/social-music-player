package com.jiunes.music.client.http;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class HttpTransportClient {
	HttpClient httpclient;
	HttpHost httpHost;
	String endpoint;

	public HttpTransportClient(String endpoint, int port) {
		this.endpoint = endpoint;
		httpclient = HttpClients.createDefault();
		httpHost = new HttpHost(endpoint, port);
	}

	public Response get(String uri) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse response = httpclient.execute(httpHost, httpGet);
		return Response.from(response);
	}

	public Response post(String uri, String body) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(new StringEntity(body));
		HttpResponse response = httpclient.execute(httpHost, httpPost);
		return Response.from(response);
	}

	public Response put(String uri, String body) throws ClientProtocolException, IOException {
		HttpPut httpPut = new HttpPut(uri);
		httpPut.setEntity(new StringEntity(body));
		HttpResponse response = httpclient.execute(httpHost, httpPut);
		return Response.from(response);
	}

	public Response delete(String uri) throws ClientProtocolException, IOException {
		HttpDelete httpDelete = new HttpDelete(uri);
		HttpResponse response = httpclient.execute(httpHost, httpDelete);
		return Response.from(response);
	}
}
