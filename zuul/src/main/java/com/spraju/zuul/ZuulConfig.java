package com.spraju.zuul;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ZuulConfig implements FallbackProvider {

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.TEXT_PLAIN);
				return headers;
			}
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("Sorry. Something went wrong".getBytes());
			}
			public String getStatusText() throws IOException {
				return "OK";
			}
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			public int getRawStatusCode() throws IOException {
				return 200;
			}
			public void close() {
			}
		};
	}

}
