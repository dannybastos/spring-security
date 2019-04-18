package com.example.springsecurity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.jsonpath.JsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityApplicationTests {

	
	@Autowired
	private MockMvc mvc;
	
    @Test
    public void accessProtected() throws Exception {
    	mvc.perform(get("/")).andDo(print())
    		.andExpect(status().isUnauthorized());
    }
    
    @Test
    public void accessProtectedSuccess() throws Exception {
    	String accessToken = getAccessToken();
    	
    	mvc.perform(get("/")
    			.header("authorization", String.format("Bearer %s", accessToken)))
    		.andDo(print())
    		.andExpect(status().isOk());
    	
    }

	private String getAccessToken() throws Exception, UnsupportedEncodingException {
		MvcResult mvcResult = mvc.perform(
    			post("/oauth/token")
    				.header("authorization", "Basic YXBwOnNlY3JldC1hcHA=")
    				.param("grant_type", "password")
    				.param("username", "user")
    				.param("password", "secret")
    			).andDo(print())
    		.andExpect(status().isOk())
    		.andReturn();
    	
    	String accessToken = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.access_token");
		return accessToken;
	}

}
