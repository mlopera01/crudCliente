package com.example.crudCliente.service;

import com.example.crudCliente.controller.Client;

public interface ClientService {
    Client updateClient(String id, Client client);
    boolean removeClient(String id);
    Client loadClient(String id);
    Client createClient(Client client);
}
