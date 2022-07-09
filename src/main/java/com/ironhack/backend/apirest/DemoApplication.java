package com.ironhack.backend.apirest;

import com.ironhack.backend.apirest.models.*;
import com.ironhack.backend.apirest.repository.ClientRepository;
import com.ironhack.backend.apirest.repository.InvoiceRepository;
import com.ironhack.backend.apirest.repository.ProductRepository;
import com.ironhack.backend.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Client client = new Client("Juan", "Ideas", "muchas@ideas.com", Date.from(Instant.now()));
		clientRepository.save(client);
		Client client1 = new Client("Mr. John", "Doe", "john.doe@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client1);
		Client client2 = new Client("Linus", "Torvalds", "linus.torvalds@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client2);
		Client client3 = new Client("Rasmus", "Lerdorf", "rasmus.lerdorf@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client3);
		Client client4 = new Client("Erich", "Gamma", "erich.gamma@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client4);
		Client client5 = new Client("Richard", "Helm", "richard.helm@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client5);
		Client client6 = new Client("Avril", "Gar", "avirl.garz@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client6);
		Client client7 = new Client("Ramon", "Robinson", "ramon.eamt@gmail.com",Date.from(Instant.now()));
		clientRepository.save(client7);
		Client client8 = new Client("Imma", "Jimenez", "imma.jims@gmail.com", Date.from(Instant.now()));
		clientRepository.save(client8);

				System.out.println("Clients: OK ");

		Invoice invoice = new Invoice ( "description", "esta es una Obs", Date.from(Instant.now()), client);
		invoiceRepository.save(invoice);
		Invoice invoice1 = new Invoice ("description", "esta es una Obs", Date.from(Instant.now()), client1);
		invoiceRepository.save(invoice1);
		Invoice invoice2 = new Invoice ( "description", "esta es una Obs", Date.from(Instant.now()),client2);
		invoiceRepository.save(invoice2);
		Invoice invoice3 = new Invoice ( "description", "esta es una Obs", Date.from(Instant.now()),client3);
		invoiceRepository.save(invoice3);
		Invoice invoice4 = new Invoice ( "description", "esta es una Obs", Date.from(Instant.now()),client4);
		invoiceRepository.save(invoice4);

		System.out.println("Invoices: OK ");


		Product product = new Product();
		product.setName("Product 1");
		product.setPrice(10.0);
		productRepository.save(product);

		Product product1 = new Product();
		product1.setName("Product 2");
		product1.setPrice(20.0);
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setName("Product 3");
		product2.setPrice(30.0);
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setName("Product 4");
		product3.setPrice(40.0);
		productRepository.save(product3);

		System.out.println("Product: OK ");



		ItemInvoice itemInvoice = new ItemInvoice ();
		itemInvoice.setQuantity(1);
		itemInvoice.setProduct(product);
		invoiceRepository.save(invoice);

		ItemInvoice itemInvoice1 = new ItemInvoice ();
		itemInvoice1.setQuantity(2);
		itemInvoice1.setProduct(product1);
		invoiceRepository.save(invoice1);

		ItemInvoice itemInvoice2 = new ItemInvoice ();
		itemInvoice2.setQuantity(3);
		itemInvoice2.setProduct(product2);
		invoiceRepository.save(invoice2);

		ItemInvoice itemInvoice3 = new ItemInvoice ();
		itemInvoice3.setQuantity(4);
		itemInvoice3.setProduct(product3);
		invoiceRepository.save(invoice3);

		System.out.println("itemsInvoice: OK ");

		System.out.println("User: OK ");

	}
}
