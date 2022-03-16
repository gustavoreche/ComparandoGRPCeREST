package com.br.grpc.client;

import java.util.Arrays;

import org.springframework.http.HttpMethod;

public enum HttpMethodEnum {
	
	POST("1 - POST", 1) {
		@Override
		public HttpMethod getHttpMethod() {
			return HttpMethod.POST;
		}
	},
	GET("2 - GET", 2){
		@Override
		public HttpMethod getHttpMethod() {
			return HttpMethod.GET;
		}
	},
	PUT("3 - PUT", 3){
		@Override
		public HttpMethod getHttpMethod() {
			return HttpMethod.PUT;
		}
	},
	DELETE("4 - DELETE", 4){
		@Override
		public HttpMethod getHttpMethod() {
			return HttpMethod.DELETE;
		}
	},
	;
	
	private String text;
	private int id;
	public abstract HttpMethod getHttpMethod();

	private HttpMethodEnum(String text, int id) {
		this.text = text;
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public static HttpMethod getById(int userChoice) {
		return Arrays.asList(HttpMethodEnum.values())
			.stream()
			.filter(enumValue -> enumValue.id == userChoice)
			.findFirst()
			.get()
			.getHttpMethod();
	}
	
}
