package service;

import dominio.Cliente;
import dominio.Vendedor;

import java.util.List;
import java.util.Scanner;

public class VendedorService  implements PessoaService{
    Scanner scanner = new Scanner(System.in);


    List<Vendedor> vendedores;

    ValidacaoService validacaoService;

    public VendedorService(List<Vendedor> vendedores, ValidacaoService validacaoService) {
        this.vendedores = vendedores;
        this.validacaoService = validacaoService;
    }

    // Método cadastra vendedor

    @Override
    public void cadastrar() {

        Vendedor vendedor = new Vendedor();

        System.out.println("Nome vendedor:");

        String nome =scanner.nextLine();

        if(validacaoService.nomeENumeroOuVazio(nome)) {

            System.out.println("Formato inválido!");

            cadastrar();
        }

        vendedor.setNome(nome);

        String cpf;

        boolean cpfValido = false;

        do {

            System.out.println("CPF vendedor:");

            cpf = scanner.nextLine();

            for (Vendedor vendedor1 : vendedores) {

                if (vendedor1.getCpf().equals(cpf)) {

                    System.out.println("Vendedor já cadastrado.");

                    return;

                }
            }

            if (validacaoService.validarCPF(cpf)) {

                vendedor.setCpf(cpf);

                cpfValido = true;

            } else {

                System.out.println("O CPF informado é inválido. Insira um CPF válido.");

            }

        } while (!cpfValido);

        vendedor.setCpf(cpf);

        String email;

        boolean emailValido = false;

        do {

            System.out.println("E-mail vendedor:");

            email = scanner.nextLine();

            for (Vendedor vendedor1 : vendedores) {

                if (vendedor1.getEmail().equals(email)) {

                    System.out.println("E-mail já cadastrado.");

                    return;

                }
            }

            if (email.contains("@")) {

                vendedor.setEmail(email);

                emailValido = true;

            } else {

                System.out.println("O email informado é inválido. Insira um email válido com @.");

            }

        } while (!emailValido);

        vendedores.add(vendedor);

        System.out.println("Vendedor cadastrado com sucesso!");

        int sair;

        do {
            System.out.println("Deseja cadastrar outro vendedor? (Digite 0 para sim ou 1 para não)");

            sair = scanner.nextInt();

            scanner.nextLine();

        } while (sair != 0 &&  sair != 1);

        if (sair == 1) {

            return;

        } else if ( sair == 0) {

            cadastrar();

        }


    }
    //Método lista vendedores cadastrados

    @Override
    public void listar() {

        System.out.println("Vendedores cadastrados no sistema:");

        for (Vendedor vendedor1 : vendedores) {

            System.out.println("Nome: " + vendedor1.getNome());
            System.out.println("CPF: " + vendedor1.getCpf());
            System.out.println("E-mail: " + vendedor1.getEmail());
            System.out.println("---------------------------------------");

        }

    }

    // Método verifica se o vendedor já é cadastrado no sistema, levando em conta o CPF
    @Override
    public boolean verificarSeECadastrado(String cpf) {

        for (Vendedor vendedor : vendedores) {

            if (vendedor.getCpf().equals(cpf)) {

                return true; // Cliente encontrado, está cadastrado

            }
        }

        return false; // Cliente não encontrado, não está cadastrado

    }

    // Método retorna um cliente da lista, levando em conta o cpf

    public Vendedor obterVendedorPorCpf(String cpf) {

        for (Vendedor vendedor : vendedores) {

            if (vendedor.getCpf().equals(cpf)) {

                return vendedor;

            }
        }
        return null;
    }

}
