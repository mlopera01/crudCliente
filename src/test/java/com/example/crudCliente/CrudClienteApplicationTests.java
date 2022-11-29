package com.example.crudCliente;
import com.example.crudCliente.controller.Client;
import com.example.crudCliente.service.ClientService;
import com.example.crudCliente.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//@SpringBootTest usamos Jupiter, esto no aplica
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
		client.setEmail("ihernand@proteccion.com.co");
		Client result = clienteService.createClient(client); //aca invocamo la funcion crear
		Assertions.assertNotNull(result.getCreatedDate()); //como usamos Jupiter no requiere mensaje
		System.out.println("Client: "+ result);
		Assertions.assertEquals(client.getDocument(),result.getDocument()); //valida si fue seteado el cliente retornado
		Assertions.assertEquals(client.getFirstName(),result.getFirstName());
	}
	@Test
	void testUpdateClient_WhenDocumentNotNull_ThenRegistrationDateNotNull() {
		Client client = new Client();
		client.setDocument("43630233");
		Client result = clienteService.updateClient("123", client);
		Assertions.assertNotNull(result.getUpdatedDate());
		System.out.println("Update Client: "+ result);
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