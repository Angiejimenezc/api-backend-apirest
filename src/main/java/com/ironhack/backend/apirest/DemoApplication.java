package com.ironhack.backend.apirest;

import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Client client = new Client("Juan", "Perez", "profesor@ideas.com", new Date());
		clientRepository.save(client);
		Client client1 = new Client("Mr. John", "Doe", "john.doe@gmail.com", new Date());
		clientRepository.save(client1);
		Client client2 = new Client("Linus", "Torvalds", "linus.torvalds@gmail.com", new Date());
		clientRepository.save(client2);
		Client client3 = new Client("Rasmus", "Lerdorf", "rasmus.lerdorf@gmail.com", new Date());
		clientRepository.save(client3);
		Client client4 = new Client("Erich", "Gamma", "erich.gamma@gmail.com", new Date());
		clientRepository.save(client4);
		Client client5 = new Client("Richard", "Helm", "richard.helm@gmail.com", new Date());
		clientRepository.save(client5);
		Client client6 = new Client("Ralph", "Johnson", "ralph.johnson@gmail.com", new Date());
		clientRepository.save(client6);


		System.out.println("Clients: OK ");






	}
}
