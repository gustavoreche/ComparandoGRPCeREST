package com.br.grpc.client;

import java.util.Objects;
import java.util.Scanner;

public class ConnectionClientMain {
	
	public static void main(String[] args) throws InterruptedException {
		ConnectionService connectionService = new ConnectionService();
		connectionService.textWelcome();
		
		Scanner inputUser = new Scanner(System.in);
		long quantityRequest = 0;
		while(true) {
			TypeOfConnectionEnum typeOfConnection = null;
			while(Objects.isNull(typeOfConnection)) {
				connectionService.textChoiceCommunication();
				typeOfConnection = connectionService.getCommunicationUserChoice(inputUser);
				
				if(Objects.isNull(typeOfConnection)) {
					connectionService.textInvalidOption();
				} else {
					quantityRequest = connectionService.getQuantityRequestUserChoice(inputUser);
				}
			}
			
			connectionService.executeRequests(quantityRequest, typeOfConnection);
		}
    }

}
