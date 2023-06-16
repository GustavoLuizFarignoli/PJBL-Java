package Registros;
import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import java.util.Date;
public class RegistroAluguel extends Registro {
    private int tempo;
    private double valor;
    private Automovel automovel;
    private Cliente cliente;
    private Vendedor vendedor;
    private Date dataAluguel;

    public static void registrarAluguel(Automovel automovel, Cliente cliente, Vendedor vendedor, Date dataAluguel, double valorAluguel) {
        automovel = automovel;
        cliente = cliente;
        vendedor = vendedor;
        dataAluguel = dataAluguel;
        valorAluguel = valorAluguel;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public int getTempo() {
        return tempo;
    }

    public double getValor() {
        return valor;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

