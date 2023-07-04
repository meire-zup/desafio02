package service;

import dominio.Cliente;
import dominio.Venda;
import dominio.Vendedor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoVendaService implements  GerenciamentoService{
    ClienteService clienteService;

    VendedorService vendedorService;

    Cliente cliente;

    Vendedor vendedor;

    List<Venda> vendasCadastradas;



    public GerenciamentoVendaService(ClienteService clienteService, VendedorService vendedorService, List<Venda> vendasCadastradas) {

        this.clienteService = clienteService;
        this.vendedorService = vendedorService;
        this.vendasCadastradas = vendasCadastradas;

    }

    Scanner scanner = new Scanner(System.in);

    // Método cadastra vendas
    @Override
    public void cadastrarVenda() {

        System.out.println("Informe o cpf do cliente:");

        String cpfCliente = scanner.nextLine();

        System.out.println("Informe o cpf do vendedor:");

        String cpfVendedor = scanner.nextLine();

        if(clienteService.verificarSeECadastrado(cpfCliente) && vendedorService.verificarSeECadastrado(cpfVendedor)) {

            Venda venda = new Venda();

            cliente = clienteService.obterClientePorCpf(cpfCliente);
            venda.setCliente(cliente);
            vendedor = vendedorService.obterVendedorPorCpf(cpfVendedor);
            venda.setVendedor(vendedor);

            Double valorTotal = null;

            do {

                try {
                    System.out.println("Informe o valor da venda:");

                    String entrada = scanner.nextLine();

                    valorTotal = Double.parseDouble(entrada);

                    if(Double.isNaN(valorTotal)) {

                        throw new InputMismatchException("Valor inválido!");

                    }

                } catch (InputMismatchException | NumberFormatException e) {

                    System.out.println(e.getMessage());

                    valorTotal= null;

                }

            } while (valorTotal == null);
            venda.setValorTotal(valorTotal);

            venda.setDataRegistro(LocalDate.now());
            vendasCadastradas.add(venda);


        } else if (!clienteService.verificarSeECadastrado(cpfCliente) && vendedorService.verificarSeECadastrado(cpfVendedor)) {

            System.out.println("Cliente não cadastrado!");

        } else if (clienteService.verificarSeECadastrado(cpfCliente) && !vendedorService.verificarSeECadastrado(cpfVendedor)) {

            System.out.println("Vendedor não cadastrado!");

        } else {

            System.out.println("Cliente e vendedor não cadastrados!");

        }

        int sair;

        do {
            System.out.println("Deseja cadastrar outro venda? (Digite 0 para sim ou 1 para não)");

            sair = scanner.nextInt();

            scanner.nextLine();

        } while (sair != 0 &&  sair != 1);

        if (sair == 1) {

            return;

        } else if ( sair == 0) {

            cadastrarVenda();

        }


    }

    // Método lista vendas
    @Override
    public void listarVenda() {

        System.out.println("------ VENDAS CADASTRADAS ------");
        for (Venda venda : vendasCadastradas) {
            System.out.println("Id: " + venda.getId());
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Cpf:" + venda.getCliente().getCpf());
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Valor total da venda: " + venda.getValorTotal());
            System.out.println("Data: " + venda.getDataRegistro());
            System.out.println("-------------------------------------");

        }

    }
    // Método lista compras de um cliente, levando em conta o cpf;
    public void listarComprasPorCliente () {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfCliente = scanner.nextLine();
        System.out.println("---------- COMPRAS ----------");
        for (Venda venda : vendasCadastradas) {
            if (venda.getCliente().getCpf().equals(cpfCliente)) {
                System.out.println("Data da compra: " + venda.getDataRegistro());
                System.out.println("Valor da compra: " + venda.getValorTotal());
                System.out.println("---------------------------------------");
                temVendas = true;

            }

        }
        if (temVendas == false) {

            System.out.println("Cliente não possui compra!");

        }

    }

    // Método lista vendas de um vendedor, levando em conta o cpf
    public void listarVendasPorVendedor () {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfVendedor = scanner.nextLine();
        System.out.println("---------- VENDAS ----------");
        for (Venda venda : vendasCadastradas) {
            if (venda.getVendedor().getCpf().equals(cpfVendedor)) {
                System.out.println("Data da venda: " + venda.getDataRegistro());
                System.out.println("Valor da venda: " + venda.getValorTotal());
                System.out.println("---------------------------------------");
                temVendas = true;

            }

        }
        if (temVendas == false) {

            System.out.println("Vendedor não possui compra!");

        }

    }
}
