package org.khl.chat;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ChatClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChatClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws IOException {
//    	System.out.println("dfbg");
//    	System.in.read();
//    	System.out.println("fgsfbv");
    	
    	Scanner console = new Scanner(System.in);
    	String name = console.nextLine();
    	System.out.println(name);
    	name = name.trim();
    	System.out.println(name);
    	
    }
}
