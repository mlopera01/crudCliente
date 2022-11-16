package com.example.crudCliente.controller;

import com.example.crudCliente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping( "/client" )

public class ClientController {
    private final ClientService clientService;

    public ClientController(@Autowired ClientService ns) {
        this.clientService = ns;
    }

    /*Otra forma para hacer el Get
    * @GetMapping("/client")
    * @ResponseBody
    * public ResponseEntity<Client> loadClient(@RequestParam String id)
    * En postman la invocación es: localhost:8080/client?id=43630233
    *
    * Otra forma:
     * @GetMapping("/client/{id}")
     * @ResponseBody
     * public ResponseEntity<Client> loadClient(String id)
     * En postman la invocación es: localhost:8080/client/43630233
     *
    * */

    @GetMapping("/{id}") //load
    @ResponseBody
    public ResponseEntity<Client> loadClient(@PathVariable String id) {
        return ResponseEntity.ok(clientService.loadClient(id));
    }

    @PutMapping("/{id}") //update
    @ResponseBody
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client cliente) {
        return ResponseEntity.ok(clientService.updateClient(id, cliente));
    }

    @PostMapping //create
    @ResponseBody
    public ResponseEntity<Client> createClient(@RequestBody Client cliente) {
        return ResponseEntity.ok(clientService.createClient(cliente));
    }


    @DeleteMapping ("/{id}") //delete
    @ResponseBody
    public ResponseEntity<Boolean> removeClient(@PathVariable String id) {
        return ResponseEntity.ok(clientService.removeClient(id));
    }

}



