package com.br.grpc.client;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.http.HttpMethod;

public class ConnectionService {
	
	public void textWelcome() throws InterruptedException {
		System.err.println("BEM VINDO ao COMPARADOR de comunicacoes");
		Thread.sleep(200);
		System.out.println("* Para sair a qualquer momento, digite SAIR");
		Thread.sleep(200);
	}
	
	public void textChoiceCommunication() throws InterruptedException {
		Thread.sleep(800);
		System.out.println("Digite o NUMERO de qual comunicacao voce quer utilizar:");
		Thread.sleep(200);
	}
	
	public TypeOfConnectionEnum getCommunicationUserChoice(Scanner inputUser) throws InterruptedException {
		Arrays.asList(TypeOfConnectionEnum.values())
			.forEach(connection -> {
				try {
					System.out.println(connection.getText());
					Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
						}
				});
		System.out.print("R: ");
		Thread.sleep(200);
		String userChoice = inputUser.nextLine();
		isExitGame(userChoice);
		
		return TypeOfConnectionEnum.getById(userChoice);
	}
	
	private void isExitGame(String inputUser) throws InterruptedException {
		if("SAIR".equalsIgnoreCase(inputUser)) {
			System.err.println("VOCE ENCERROU O COMPARADOR. MUITO OBRIGADO!!");
			Thread.sleep(200);
			System.exit(0);
		}
	}
	
	public void textInvalidOption() throws InterruptedException {
		System.err.println("Opcao invalida!! Tente novamente");
		Thread.sleep(200);
	}
	
	public long getQuantityRequestUserChoice(Scanner inputUser) throws InterruptedException {
		boolean isInvalid = true;
		long quantity = 0;
		while(isInvalid) {
			System.out.print("Digite a quantidade de requisicoes que deseja testar: ");
			Thread.sleep(200);
			String userChoice = inputUser.nextLine();
			isExitGame(userChoice);
			quantity = getValueNumeric(userChoice);
			if(quantity > 0) {
				isInvalid = false;					
			}
		}
		return quantity;
	}

	private long getValueNumeric(String userChoice) throws InterruptedException {
		long quantityRequest = 0;
		try {
			long quantity = Long.parseLong(userChoice);
			if(quantity <= 0) {
				this.textInvalidOption();					
			} else {				
				quantityRequest = quantity;
			}
		} catch (NumberFormatException e) {
			this.textInvalidOption();
		}
		return quantityRequest;
	}
	
	public void executeRequests(long quantityRequest, 
			TypeOfConnectionEnum typeOfConnection) {
		ConnectionInterface connection = typeOfConnection.getConnection();
		connection.initConfiguration();
		
		LocalDateTime executionStart = LocalDateTime.now();
		for(int i = 0; i < quantityRequest; i++) {
			connection.sendRequest(i);
		}
		LocalDateTime executionFinish = LocalDateTime.now();
		
		System.err.println("Inicio: " + executionStart);
		System.err.println("Fim: " + executionFinish);
		System.err.println("Tempo: " + Duration.between(executionStart, executionFinish).getSeconds());
		
		connection.finishConnection();
	}
	
	public HttpMethod getHttpMethod() {
		boolean isInvalid = true;
		while(isInvalid) {
			int quantity = 0;
			try {
				quantity = this.getHttpMethodUserChoice();
				if(quantity > 0 && quantity <= 4) {
					isInvalid = false;					
					return HttpMethodEnum.getById(quantity);
				} else {
					this.textInvalidOption();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return null;
	}

	private int getHttpMethodUserChoice() throws InterruptedException {
		Arrays.asList(HttpMethodEnum.values())
		.forEach(connection -> {
			try {
				System.out.println(connection.getText());
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.print("R: ");
		Thread.sleep(200);
		String userChoice = new Scanner(System.in).nextLine();
		isExitGame(userChoice);
		return (int) getValueNumeric(userChoice);
	}

}
