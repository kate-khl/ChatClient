package org.khl.chat;

import java.util.Arrays;
import java.util.List;

import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.CreateChatRequest;
import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.LoginResponseDto;
import org.khl.chat.dto.MessageDto;
import org.khl.chat.dto.SendMessageRequest;
import org.khl.chat.dto.Session;
import org.khl.chat.dto.UserDto;
import org.khl.chat.exception.IllegalStateException;
import org.khl.chat.exception.InvalidCommandParamException;
import org.khl.chat.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

	private static final String URL_SIGN_IN = "http://127.0.0.1:8080/auth";
	private static final String URL_SIGN_UP = "http://127.0.0.1:8080/registration";
	private static final String URL_GET_USERS = "http://127.0.0.1:8080/users/list";
	private static final String URL_CREATE_CHAT = "http://127.0.0.1:8080/chats";
	private static final String URL_SEND_MSG = "http://127.0.0.1:8080/chats/{id}/messages";
	private static final String URL_GET_CHATS = "http://127.0.0.1:8080/user/{id}/chats";
	private static final String URL_GET_MSGS = "http://127.0.0.1:8080/chats/{id}/messages";
	
	
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
		} catch (HttpClientErrorException e) {
			throw new InvalidCommandParamException(e.getStatusCode() + ": " + e.getStatusText());
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
			return Arrays.asList(response.getBody());
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}

	public ChatDto createChat(String token, CreateChatRequest createChat) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			HttpEntity<CreateChatRequest> entity = new HttpEntity<>(createChat, headers);
			ResponseEntity<ChatDto> response = restTemplate.postForEntity(URL_CREATE_CHAT, entity, ChatDto.class); 
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
	public List<ChatDto> getChats(String token) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<ChatDto[]> response = restTemplate.exchange(URL_GET_CHATS.replace("{id}", app.getId().toString()), HttpMethod.GET, entity, ChatDto[].class, 1, 5);
			return Arrays.asList(response.getBody());
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
	public MessageDto sendMessage(String token, Long chatId, String message) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			HttpEntity<SendMessageRequest> entity = new HttpEntity<>(new SendMessageRequest(message), headers);
			ResponseEntity<MessageDto> response = restTemplate.postForEntity(URL_SEND_MSG.replace("{id}", chatId.toString()), entity, MessageDto.class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
	public List<MessageDto> getMessages(String token, Long chatId) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<MessageDto[]> response = restTemplate.exchange(URL_GET_MSGS.replace("{id}", chatId.toString()), HttpMethod.GET, entity, MessageDto[].class, 1, 5);
			return Arrays.asList(response.getBody());
		} catch (ResourceAccessException e) {
			throw new IllegalStateException("Сервер недоступен.");		
		}
	}
	
}
