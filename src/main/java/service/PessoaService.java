package service;

import dominio.Cliente;
import dominio.Venda;

import java.util.List;

public interface PessoaService {

    void cadastrar();
    void listar();

    Venda cadastrarVenda();
    List<Venda> listarVendas();





}
