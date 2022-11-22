package com.example.crudCliente;

import com.example.crudCliente.controller.Client;
import com.example.crudCliente.service.ClientService;
import com.example.crudCliente.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

//@SpringBootTest
class CrudClienteApplicationTests {
	//@Autowired
	private ClientService clienteService = new ClientServiceImpl();

	@Test
	void testCreateClient_WhenDocumentNotNull_ThenCreated() {
		Client client = new Client();
		client.setId("789");
		client.setFirstName("Ingrid");
		client.setLastName("Hernandez");
		client.setDocument("43110225");
		client.setCreatedDate(new Date());
		client.setEmail("ihernand@proteccion.com.co");
		//assertThat(client.getCreatedDate()).isNotNull();
		System.out.println("Cliente: "+client);
		Assertions.assertEquals("43110225",client.getDocument());
	}
	@Test
	void testUpdateClient_WhenDocumentNotNull_ThenRegistrationDateNotNull() {
		Client client = new Client();
		client.setDocument("43630233");
		Client clientResult = clienteService.updateClient("123", client);
		//client.setCreatedDate(null);
		Assertions.assertNotNull(clientResult.getUpdatedDate());
		System.out.println("Cliente Actualizado: "+clientResult);
		//Assertions.assertEquals("71790754",client.getDocument());
	}

	@Test
	void testUpdateClient_WhenDocumentNull_ThenFailed() {
		Client client = new Client();
		client.setEmail("jzulu2000@gmail.com");
		//client.setDocument("71790754");
		client.setPhone("3013325522");
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> clienteService.updateClient("71790754", client));

		//Client client1 = ;
		//Assertions.assertEquals("71790754",client1.getDocument());
		//Assertions.assertNotEquals("43630233",client1.getDocument());
		//Assertions.assertEquals("3013325522", client1.getPhone());
	}
}