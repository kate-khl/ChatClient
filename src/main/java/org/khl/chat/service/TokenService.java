package org.khl.chat.service;

import java.util.Base64;
import org.khl.chat.AppData;
import com.google.gson.Gson;

public class TokenService {

	public void parse(String token) {
		token = token.replace("_", "+").replace("-", "/");
		
		String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];		
        System.out.println(base64EncodedHeader);
        System.out.println(base64EncodedBody);
        
        String body = new String(Base64.getMimeDecoder().decode(base64EncodedBody));
        Gson gson = new Gson();
        AppData ss = gson.fromJson(body, AppData.class);
	}
}
