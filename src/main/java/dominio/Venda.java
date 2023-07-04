package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {

    private Cliente cliente;
    private Vendedor vendedor;
    private Double valorTotal;
    private LocalDate dataRegistro;
    private int id;

    public Venda() {

        this.id = proximoId;
        proximoId++;

    }

    public int getId() {
        return id;
    }

    private static int proximoId;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }


}
