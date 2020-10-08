package org.khl.chat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.khl.chat.command.CommandScanner;
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
	@Autowired 
	private Scanner console;
	
	public static void main(String[] args) {
      		SpringApplication.run(ChatClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws IOException {

    	System.out.println("\n\n***Начало работы*** " + 
    			"\n Для регистрации введите $signup -name yourname -email your@email.com -password yourpassword" 
    		  + "\n Для входа введите $signin -email your@email.com -password yourpassword " 
    		  + "\n Для получения справки введите $help");
    	
//    	Scanner console = new Scanner(System.in);
    	scan(console);
    }
    
    private void scan(Scanner console) {
    	System.out.println(cmdScan.parse(console.nextLine()));
    	scan(console);
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    
    @Bean
    public Scanner getScanner() {
    	return new Scanner(System.in);
    }
    
}
