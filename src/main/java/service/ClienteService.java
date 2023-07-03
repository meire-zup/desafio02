package service;

import dominio.Cliente;
import dominio.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ClienteService implements PessoaService {

    Cliente cliente;

    List<Cliente> clientes;

    public ClienteService(Cliente cliente, List<Cliente> clientes) {
        this.cliente = cliente;
        this.clientes = clientes;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrar() {

        System.out.println("Informe seu nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.println("Informe seu cpf: ");
        cliente.setCpf(scanner.nextLine());

        System.out.println("Informe seu e-mail:");
        cliente.setEmail(scanner.nextLine());

        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

    }

    @Override
    public void listar() {
        System.out.println("Clientes cadastrados no sistema:");
        for (Cliente cliente1 : clientes) {

            System.out.println("Nome: " + cliente1.getNome());
            System.out.println("CPF: " + cliente1.getCpf());
            System.out.println("E-mail: " + cliente1.getEmail());
            System.out.println("---------------------------------------");
        }

    }

    public void listar2() {

        clientes.toString();
    }

    @Override
    public Venda cadastrarVenda() {
        return null;
    }

    @Override
    public List<Venda> listarVendas() {
        return null;
    }


}
