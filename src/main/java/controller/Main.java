package controller;

import dominio.Cliente;
import dominio.Venda;
import dominio.Vendedor;
import service.ClienteService;
import service.GerenciamentoVendaService;
import service.VendedorService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Cliente> clientes = new ArrayList<>();
        List<Vendedor> vendedores = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        ClienteService clienteService = new ClienteService(clientes);
        VendedorService vendedorService = new VendedorService(vendedores);
        GerenciamentoVendaService gerenciamentoVendaService = new GerenciamentoVendaService(clienteService, vendedorService, vendas);

        clienteService.cadastrar();
        clienteService.cadastrar();
        System.out.println("--------------------------------");
        //clienteService.listar();
        //vendedorService.cadastrar();
        //vendedorService.cadastrar();
        System.out.println("--------------------------------");
        vendedorService.listar();
        gerenciamentoVendaService.cadastrarVenda();
        gerenciamentoVendaService.cadastrarVenda();
        gerenciamentoVendaService.cadastrarVenda();
        gerenciamentoVendaService.cadastrarVenda();
        gerenciamentoVendaService.cadastrarVenda();
        gerenciamentoVendaService.listarVenda();
        gerenciamentoVendaService.listarVendasPorVendedor();
        gerenciamentoVendaService.listarComprasPorCliente();



    }

}
