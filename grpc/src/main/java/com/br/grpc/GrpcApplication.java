package com.br.grpc;

import java.io.IOException;

import com.br.grpc.service.HelloServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

public class GrpcApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = ServerBuilder
		          .forPort(8090)
		          .addService(new HelloServiceImpl()).build();

		        Server startServer = server.start();
		        for(ServerServiceDefinition svc : startServer.getServices()) {
		            System.out.println("Bootstrapping services : " + svc.getServiceDescriptor().getName());
		        }
		        server.awaitTermination();
	}

}
