package controller;

import dominio.Cliente;
import service.ClienteService;
import service.GerenciamentoVendaService;
import service.VendedorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in);

    List<Cliente> clientes = new ArrayList<>();
    ClienteService clienteService = new ClienteService(clientes);

    VendedorService vendedorService = new VendedorService(new ArrayList<>());

    GerenciamentoVendaService gerenciamentoVendaService = new GerenciamentoVendaService(clienteService, vendedorService, new ArrayList<>());

    public void menu() {

        int escolha = -1;

        do {

            try {

                System.out.println("1 - CADASTRAR CLIENTE");
                System.out.println("2 - CADASTRAR VENDEDOR");
                System.out.println("3 - REGISTRAR VENDA");
                System.out.println("4 - LISTAR CLIENTES CADASTRADOS");
                System.out.println("5 - LISTAR VENDEDORES CADASTRADOS");
                System.out.println("6 - LISTAR VENDAS REGISTRADAS");
                System.out.println("7 - LISTAR COMPRAS POR CLIENTE");
                System.out.println("8 - LISTAR VENDAS POR VENDEDORES");
                System.out.println("0 - SAIR");

                escolha = scanner.nextInt();

                switch (escolha) {

                    case 1:
                        clienteService.cadastrar();
                        break;

                    case 2:
                        vendedorService.cadastrar();
                        break;

                    case 3:
                        gerenciamentoVendaService.cadastrarVenda();
                        break;

                    case 4:
                        clienteService.listar();
                        break;

                    case 5:
                        vendedorService.listar();
                        break;

                    case 6:
                        gerenciamentoVendaService.listarVenda();
                        break;

                    case 7:
                        gerenciamentoVendaService.listarComprasPorCliente();
                        break;

                    case 8:
                        gerenciamentoVendaService.listarVendasPorVendedor();
                        break;

                    case 0:

                        System.out.println("FIM");
                        break;

                    default:

                        throw new IllegalArgumentException("Valor inválido");
                }

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());

            }
        } while (escolha < 0 || escolha > 8);

    }
}
