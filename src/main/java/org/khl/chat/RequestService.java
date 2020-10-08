package org.khl.chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.LoginResponseDto;
import org.khl.chat.dto.Session;
import org.khl.chat.dto.UserDto;
import org.khl.chat.exception.IllegalStateException;
import org.khl.chat.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

	private static final String URL_SIGN_IN = "http://127.0.0.1:8080/auth";
	private static final String URL_SIGN_UP = "http://127.0.0.1:8080/registration";
	private static final String URL_GET_USERS = "http://127.0.0.1:8080//users/list";
	
	@Autowired
	AppData app;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UserDto signUp (UserDto uDto) {
		HttpEntity<UserDto> requestBody = new HttpEntity<>(uDto);
		
		try {
			ResponseEntity<UserDto> response = restTemplate.postForEntity(URL_SIGN_UP, requestBody, UserDto.class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
	public UserDto signIn(LoginRequestDto loginDto) {
		try {
			HttpEntity<LoginRequestDto> requestBody = new HttpEntity<>(loginDto);
			ResponseEntity<LoginResponseDto> response = restTemplate.postForEntity(URL_SIGN_IN, requestBody, LoginResponseDto.class);
			UserDto user = response.getBody().getUserDto();
			if (user != null)
			{
				String token = response.getBody().getToken();
				app.setToken(token);
				app.setFieldsFromSession(Session.getFromToken(token));
				app.setPassword(loginDto.getPassword());
				return response.getBody().getUserDto();
			}
			else throw new NotFoundException("Пользователь не найден");
			
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		} catch (HttpClientErrorException e) {
			throw new NotFoundException("Пользователь не найден");
		}
		
	}
	
	public List<UserDto> getUsers(String token) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<UserDto[]> response = restTemplate.exchange(URL_GET_USERS + "?page={page}1&size={size}", HttpMethod.GET, entity, UserDto[].class, 1, 5);
			
		//	ResponseEntity<UserDto[]> response1 = restTemplate.getForEntity(URL_GET_USERS, UserDto[].class);
			return Arrays.asList(response.getBody());
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
}
