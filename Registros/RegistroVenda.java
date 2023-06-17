package Registros;
import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;

public class RegistroVenda extends Registro {
    private Vendedor vendedor;
    private double valorVenda;

    public RegistroVenda(Automovel automovel, double valorVenda, Cliente cliente, Vendedor vendedor) {
        super(automovel, cliente);
        this.vendedor = vendedor;
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Vendedor: " + this.vendedor.getNome() +
                "\nAutomovel: " + getAutomovel().getModelo() +
                "\nValor: " + this.valorVenda +
                "\nComprador: " + getCliente().getNome();
    }
}
