package com.br.grpc.client;

public interface ConnectionInterface {
	
	public void initConfiguration();
	public void sendRequest(int iteration);
	public void finishConnection();

}
