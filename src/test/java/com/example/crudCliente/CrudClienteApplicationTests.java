package com.example.crudCliente;

import com.example.crudCliente.controller.Client;
import com.example.crudCliente.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class CrudClienteApplicationTests {
	@Autowired
	private ClientService clienteService;

	@Test
	void clientHasRegistrationDate() {
		//Client client = new Client();
		Client client = clienteService.loadClient("123");
		//assertThat(client.getCreatedDate()).isNotNull();
		System.out.println("CLIENTE: "+client);
		Assertions.assertEquals("71790754",client.getDocument());
	}

}