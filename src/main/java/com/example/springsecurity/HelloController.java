package com.example.springsecurity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed(value = "ROLE_USER")
public class HelloController {

	private ObjectMapper mapper;

	public HelloController(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/")
	public String index() throws JsonProcessingException {
		HelloDTO helloDTO = new HelloDTO("Hello World!");
		return mapper.writeValueAsString(helloDTO);
	}
	
}
