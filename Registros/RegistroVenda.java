package Registros;

import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import java.util.Date;

public class RegistroVenda{
    private Vendedor vendedor;
    private Cliente cliente;
    private Date dataVenda;
    private Automovel automovel;
    private double valorVenda;

    public static void registrarVenda(Automovel automovel, Vendedor vendedor, Cliente cliente, Date dataVenda, double valorVenda) {
        automovel = automovel;
        vendedor = vendedor;
        cliente = cliente;
        dataVenda = dataVenda;
        valorVenda = valorVenda;
    }
}
