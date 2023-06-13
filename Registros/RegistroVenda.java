package Registros;
import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import java.util.Date;

public class RegistroVenda{
    private Vendedor vendedor;
    private Date dataVenda;
    private Automovel automovel;
    private double valorVenda;

    private Cliente cliente;
    public RegistroVenda(Automovel automovel, Vendedor vendedor, Cliente cliente, Date dataVenda, double valorVenda) {
        automovel = automovel;
        vendedor = vendedor;
        cliente = cliente;
        dataVenda = dataVenda;
        valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Vendedor:" + vendedor +
                "\nData da Venda: " + dataVenda +
                "\nAutomovel: " + automovel +
                "\nValor: " + valorVenda +
                "\n Comprador: " + cliente;
    }
}
