package org.khl.chat;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class ChatClientApplication implements CommandLineRunner {

	@Autowired
	private CommandScanner cmdScan;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws IOException {

    	System.out.println("\n\n***Меню*** " + 
    			"\n Для регистрации введите signup -name yourname -email your@email.com -password yourpassword" 
    		  + "\n Для входа введите singin login your@email.com password yourpassword " 
    		  + "\n Для получения справки введите help");
    	
    	Scanner console = new Scanner(System.in);
    	System.out.println(cmdScan.parse(console.nextLine()));

    	
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
