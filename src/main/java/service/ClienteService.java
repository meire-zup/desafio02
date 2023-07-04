package service;

import dominio.Cliente;
import dominio.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ClienteService implements PessoaService {

    List<Cliente> clientes;


    public ClienteService(List<Cliente> clientes) {

        this.clientes = clientes;
    }

    Scanner scanner = new Scanner(System.in);

    public void cadastrar() {

        Cliente cliente = new Cliente();

        System.out.println("Nome cliente:");
        cliente.setNome(scanner.nextLine());


        String cpf;

        //System.out.println("CPF cliente:");

        //cpf = scanner.nextLine();




        boolean cpfValido = false;

        do {
            System.out.println("CPF cliente:");
            cpf = scanner.nextLine();
            for (Cliente cliente1 : clientes) {

                if (cliente1.getCpf().equals(cpf)) {
                    System.out.println("Cliente já cadastrado.");
                    return;

                }
            }

            if (validarCPF(cpf)) {
                cliente.setCpf(cpf);
                cpfValido = true;
            } else {
                System.out.println("O CPF informado é inválido. Insira um CPF válido.");
            }
        } while (!cpfValido);



        cliente.setCpf(cpf);

        String email;
        boolean emailValido = false;


        do {
            System.out.println("E-mail cliente:");
            email = scanner.nextLine();



            for (Cliente cliente1 : clientes) {

                if (cliente1.getEmail().equals(email)) {
                    System.out.println("E-mail já cadastrado.");
                    return;

                }
            }


            if (email.contains("@")) {
                cliente.setEmail(email);
                emailValido = true;
            } else {
                System.out.println("O email informado é inválido. Insira um email válido com @.");
            }
        } while (!emailValido);


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
    @Override
    public boolean verificarSeECadastrado(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }


    public Cliente obterClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private boolean validarCPF(String cpf) {

        cpf = cpf.replaceAll("\\D+", "");

        if (cpf.length() != 11) {

            return  false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;

    }
}
