package org.khl.chat;

import org.springframework.stereotype.Component;

@Component
public final class Application {
	 
//    private static Application INSTANCE;
    private String token;
    
    private Application() {        
    }
    
//    public static Application getInstance() {
//        if(INSTANCE == null) {
//            INSTANCE = new Application();
//        }
//        
//        return INSTANCE;
//    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
