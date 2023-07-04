package service;

import dominio.Vendedor;

import java.util.List;
import java.util.Scanner;

public class VendedorService  implements PessoaService{
    Scanner scanner = new Scanner(System.in);


    List<Vendedor> vendedores;

    public VendedorService(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    @Override
    public void cadastrar() {

        Vendedor vendedor = new Vendedor();
        System.out.println("Nome vendedor:");
        vendedor.setNome(scanner.nextLine());

        String cpf;
        boolean clienteExiste = false;


        System.out.println("CPF cliente:");

        cpf = scanner.nextLine();

        for (Vendedor vendedor1 : vendedores) {

            if (vendedor1.getCpf().equals(cpf)) {
                System.out.println("Vendedor já cadastrado.");
                clienteExiste = true;
                return;

            }
        }

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


    }

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
    @Override
    public boolean verificarSeECadastrado(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return true; // Cliente encontrado, está cadastrado
            }
        }
        return false; // Cliente não encontrado, não está cadastrado
    }

    public Vendedor obterVendedorPorCpf(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        return null; // Cliente não encontrado, pode lançar uma exceção ou tratar de outra forma, conforme necessário
    }

    public void obterVendedorPorCpf2(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                System.out.println(vendedor.getNome());
            }
        }

    }
}
