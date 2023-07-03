package org.example;

import dominio.Cliente;
import service.ClienteService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ClienteService clienteService = new ClienteService(new Cliente(), new ArrayList<>());

        clienteService.cadastrar();
        clienteService.cadastrar();

        clienteService.listar();



    }
}