package service;

import dominio.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteService implements PessoaService {

    List<Cliente> clientes;

    ValidacaoService validacaoService;
    Scanner scanner = new Scanner(System.in);


    public ClienteService(List<Cliente> clientes, ValidacaoService validacaoService) {

        this.clientes = clientes;
        this.validacaoService = validacaoService;

    }

    // Método cadastra cliente
    public void cadastrar() {

        Cliente cliente = new Cliente();

        System.out.println("Nome cliente:");

        String nome =scanner.nextLine();


        if(validacaoService.nomeENumeroOuVazio(nome)) {

            System.out.println("Formato inválido!");
            cadastrar();

        }

        cliente.setNome(nome);


        String cpf;

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

            if (validacaoService.validarCPF(cpf)) {

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

        int sair;

        do {
            System.out.println("Deseja cadastrar outro cliente? (Digite 0 para sim ou 1 para não)");

            sair = scanner.nextInt();

            scanner.nextLine();

        } while (sair != 0 &&  sair != 1);

        if (sair == 1) {

            return;

        } else if ( sair == 0) {

            cadastrar();
        }

    }

    //Método lista clientes cadastrados
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

    // Método verifica se o cliente já é cadastrado no sistema, levando em conta o CPF
    @Override
    public boolean verificarSeECadastrado(String cpf) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {

                return true;

            }
        }

        return false;
    }

   // Método retorna um cliente da lista, levando em conta o cpf
    public Cliente obterClientePorCpf(String cpf) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {

                return cliente;
            }
        }

        return null;

    }



}
