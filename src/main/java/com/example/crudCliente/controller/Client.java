package com.example.crudCliente.controller;

import lombok.*;

import java.util.Date;

@Data //Para incluir los gets y los sets
@NoArgsConstructor
//@AllArgsConstructor
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String phone;
    private Date createdDate;
    private Date updatedDate;
}
