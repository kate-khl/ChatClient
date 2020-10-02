package org.khl.chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.LoginResponseDto;
import org.khl.chat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

	private static final String URL_SIGN_IN = "http://127.0.0.1:8080/auth";
	private static final String URL_SIGN_UP = "http://127.0.0.1:8080/registration";
	private static final String URL_GET_USERS = "http://127.0.0.1:8080//users/list";
	
	@Autowired
	Session app;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UserDto signUp (UserDto uDto) {
		HttpEntity<UserDto> requestBody = new HttpEntity<>(uDto);
		ResponseEntity<UserDto> response = restTemplate.postForEntity(URL_SIGN_UP, requestBody, UserDto.class);
		return response.getBody();
	}
	
	public UserDto signIn(LoginRequestDto loginDto) {
		try {
			HttpEntity<LoginRequestDto> requestBody = new HttpEntity<>(loginDto);
			ResponseEntity<LoginResponseDto> response = restTemplate.postForEntity(URL_SIGN_IN, requestBody, LoginResponseDto.class);
			app.setToken(response.getBody().getToken());
			return response.getBody().getUserDto();
		}
		catch (HttpClientErrorException ex) {
			return null;
		}
		catch (HttpServerErrorException ex) {
			return null;
		}
	}
	
	public Collection<UserDto> getUsers(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		ResponseEntity<UserDto[]> response = restTemplate.getForEntity(URL_GET_USERS, UserDto[].class);
		return Arrays.asList(response.getBody());
	}
	
}
