package service_teste;

import dominio.Cliente;
import org.junit.Before;
import org.junit.Test;
import service.ClienteService;
import service.ValidacaoService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    private List<Cliente> clientes;
    private ClienteService clienteService;

    private  ValidacaoService validacaoService = new ValidacaoService();

    @Before
    public void setup() {
        clientes = new ArrayList<>();
        clienteService = new ClienteService(clientes, validacaoService);
    }

    @Test
    public void testCadastrar() {
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";

        // Criação do mock para simular a entrada do usuário
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextLine())
                .thenReturn(nome)
                .thenReturn(cpf)
                .thenReturn(email);

       // clienteService.cadastrar(scannerMock);

        assertEquals(1, clientes.size());
        assertEquals(nome, clientes.get(0).getNome());
        assertEquals(cpf, clientes.get(0).getCpf());
        assertEquals(email, clientes.get(0).getEmail());
    }
}