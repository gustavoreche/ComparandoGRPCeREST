package com.br.grpc.client.typesConnection;

import java.util.Objects;

import com.br.grpc.client.ConnectionInterface;
import com.br.grpc.generated.HelloRequest;
import com.br.grpc.generated.HelloResponse;
import com.br.grpc.generated.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcConnection implements ConnectionInterface {
	
	private ManagedChannel channel;
	private HelloServiceGrpc.HelloServiceBlockingStub stub;

	@Override
	public void initConfiguration() {
		if(Objects.isNull(this.channel)) {
			this.channel = ManagedChannelBuilder
					.forAddress("localhost", 8090)
					.usePlaintext()
					.build();
			
			this.stub = HelloServiceGrpc.newBlockingStub(this.channel);					
		}
	}

	@Override
	public void sendRequest(int iteration) {
		HelloResponse helloResponse = this.stub.hello(HelloRequest.newBuilder()
    			.setFirstName("Gustavo")
    			.setLastName("Reche")
    			.build());
    	System.err.println("Response: " + iteration
    			+ " - " + helloResponse.getGreeting());
	}

	@Override
	public void finishConnection() {
		channel.shutdown();
	}

}
