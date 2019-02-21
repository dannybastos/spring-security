package com.example.springsecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http
        .csrf()
            .disable()
        .authorizeRequests()
            .anyRequest().authenticated()
//        .and()
//        	.httpBasic()
        .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
         .and()
         	.formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//		super.configure(auth);
		PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
		auth.inMemoryAuthentication()
			.withUser("adm")
			.password("pwd")
			.roles("ADM")
		.and().passwordEncoder(passwordEncoder);
	}
}
