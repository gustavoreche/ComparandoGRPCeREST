package br.com.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.service.HelloService;

@RestController
@RequestMapping("/rest")
public class RestResource {
	
	private HelloService restService; 
	
	public RestResource(HelloService infoService) {
		this.restService = infoService;
	}
	
	@GetMapping("/hello")
	public String getHello(@RequestParam String firstName,
			@RequestParam String lastName) {
		return this.restService.hello(firstName, lastName);
	}
	
	@PostMapping("/hello")
	public String postHello(@RequestParam String firstName,
			@RequestParam String lastName) {
		return this.restService.hello(firstName, lastName);
	}
	
	@PutMapping("/hello")
	public String putHello(@RequestParam String firstName,
			@RequestParam String lastName) {
		return this.restService.hello(firstName, lastName);
	}
	
	@DeleteMapping("/hello")
	public String deleteHello(@RequestParam String firstName,
			@RequestParam String lastName) {
		return this.restService.hello(firstName, lastName);
	}

}
