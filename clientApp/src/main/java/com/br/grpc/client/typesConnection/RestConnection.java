package com.br.grpc.client.typesConnection;

import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.br.grpc.client.ConnectionInterface;
import com.br.grpc.client.ConnectionService;

public class RestConnection implements ConnectionInterface {

	private RestTemplate restTemplate;
	private HttpEntity<String> entity;
	private HttpMethod httpMethod;
	private ConnectionService connectionService;

	@Override
	public void initConfiguration() {
		if(Objects.isNull(this.restTemplate)) {
			this.connectionService = new ConnectionService();
			this.restTemplate = new RestTemplate();
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			this.entity = new HttpEntity<String>(headers);			
		}
		this.httpMethod = this.connectionService.getHttpMethod();
	}

	@Override
	public void sendRequest(int iteration) {
		ResponseEntity<String> responseEntity = this.restTemplate
				.exchange("http://localhost:8091/rest/hello?"
						+ "firstName=Gustavo" 
						+ "&lastName=Reche",
						this.httpMethod,
						entity,
						String.class);
		System.err.println("Response: " + iteration
    			+ " - " + responseEntity.getBody());
	}

	@Override
	public void finishConnection() {
		// TODO Auto-generated method stub
	}

}
