package br.com.rest.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String hello(String firstName, String lastName) {
		return "Hello, " + firstName + " " + lastName;
	}

}
