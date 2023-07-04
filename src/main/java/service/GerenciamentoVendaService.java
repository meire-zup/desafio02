package service;

import dominio.Cliente;
import dominio.Venda;
import dominio.Vendedor;

import java.time.LocalDate;
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
            System.out.println("Informe o valor da venda:");
            Double valorTotal = scanner.nextDouble();
            scanner.nextLine();
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


    }

    @Override
    public void listarVenda() {

        System.out.println("Vendas Cadastradas:");
        for (Venda venda : vendasCadastradas) {
            System.out.println("Id: " + venda.getId());
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Cpf:" + venda.getCliente().getCpf());
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Valor total da venda: " + venda.getValorTotal());
            System.out.println("Data: " + venda.getDataRegistro());

        }

    }

    public void listarComprasPorCliente () {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfCliente = scanner.nextLine();
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

    public void listarVendasPorVendedor () {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfVendedor = scanner.nextLine();
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
