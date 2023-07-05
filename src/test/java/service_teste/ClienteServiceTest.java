package service_teste;

import dominio.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ClienteService;
import service.ValidacaoService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    private List<Cliente> clientes;

    private Cliente cliente;

    private ClienteService clienteService;

    private  ValidacaoService validacaoService = new ValidacaoService();

    @Before
    public void setup() {
        clientes = new ArrayList<>();
        cliente = new Cliente();
        clienteService = new ClienteService(clientes, validacaoService);
    }

  /*  @Test
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

        //clienteService.cadastrar(scannerMock);
        assertEquals(1, clientes.size());
        assertEquals(nome, clientes.get(0).getNome());
        assertEquals(cpf, clientes.get(0).getCpf());
        assertEquals(email, clientes.get(0).getEmail());

    }*/

    //Metodo que verifica se aquela string tem o valor informado, um exemplo é verificar se o nome do cliente é Kaio
    @Test
    public void verificaClientePossuiNomeKaio(){
        cliente.setNome("Kaio");
        //Retorna se é verdade que o nome possui Kaio
        Assert.assertTrue(verificaNomeInformado(cliente));
    }

    //Metodo de teste que testa se o email do cliente possui arroba
    @Test
    public void verificaClientePossuiArrobaNoEmail(){
        cliente.setEmail("kaio@email.com");
        //Retorna se é verdade que o email possui @
        Assert.assertTrue(verificaSeTemArroba(cliente));
    }

    //Metodo de teste que testa se o email do cliente não possui arroba
    @Test
    public void verificaClienteNaoPossuiArrobaNoEmail(){
        cliente.setEmail("kaioemail.com");
        //Retorna se é falso que o email possui @
        Assert.assertFalse(verificaSeTemArroba(cliente));
    }


    //Crie metodos que sejam genericos, que passem um objeto e voce possa usar os atributos que eles possuem dentro desses metodos como o caso abaixo onde eu passo o Cliente
    //como objeto para verificar o atributo nome dele

    //Metodo que verifica se o cliente tem nome chamado Kaio
    public boolean verificaNomeInformado(Cliente cliente){
        return Objects.equals(cliente.getNome(),"Kaio");
    }

    //Metodo que verifica se o email do cliente tem arroba
    public boolean verificaSeTemArroba(Cliente cliente){
        return cliente.getEmail().contains("@");
    }

}
