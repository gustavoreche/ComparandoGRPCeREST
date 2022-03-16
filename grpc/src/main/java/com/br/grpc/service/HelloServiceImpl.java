package com.br.grpc.service;

import com.br.grpc.generated.HelloRequest;
import com.br.grpc.generated.HelloResponse;
import com.br.grpc.generated.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, 
    		StreamObserver<HelloResponse> responseObserver) {

        HelloResponse response = HelloResponse.newBuilder()
          .setGreeting("Hello, " + request.getFirstName() + " " + request.getLastName())
          .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}