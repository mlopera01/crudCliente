package com.example.crudCliente.service;

import com.example.crudCliente.controller.Client;

import java.util.List;

public interface ClientService {
    Client updateClient(String id, Client client);
    boolean removeClient(String id);
    Client loadClient(String id);
    List<Client> loadAll();
    Client createClient(Client client);
}
