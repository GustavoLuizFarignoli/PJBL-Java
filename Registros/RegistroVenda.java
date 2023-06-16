package Registros;
import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;

public class RegistroVenda extends Registro {
    private Vendedor vendedor;
    private Automovel automovel;
    private double valorVenda;

    private Cliente cliente;
    public RegistroVenda(Automovel automovel, Vendedor vendedor, Cliente cliente, double valorVenda) {
        this.automovel = automovel;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Vendedor:" + vendedor.getNome() +
                "\nAutomovel: " + automovel.getModelo() +
                "\nValor: " + valorVenda +
                "\nComprador: " + cliente.getNome();
    }
}
