package com.br.grpc.client;

import java.util.Arrays;

import com.br.grpc.client.typesConnection.GrpcConnection;
import com.br.grpc.client.typesConnection.RestConnection;

public enum TypeOfConnectionEnum {
	
	REST("1 - REST", "1") {
		@Override
		public ConnectionInterface getConnection() {
			return new RestConnection();
		}
	},
	GRPC("2 - gRPC", "2"){
		@Override
		public ConnectionInterface getConnection() {
			return new GrpcConnection();
		}
	},
	;
	
	private String text;
	private String id;
	public abstract ConnectionInterface getConnection();

	private TypeOfConnectionEnum(String text, String id) {
		this.text = text;
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public static TypeOfConnectionEnum getById(String userChoice) {
		return Arrays.asList(TypeOfConnectionEnum.values())
			.stream()
			.filter(enumValue -> enumValue.id.equals(userChoice))
			.findFirst()
			.orElse(null);
	}
	
}
