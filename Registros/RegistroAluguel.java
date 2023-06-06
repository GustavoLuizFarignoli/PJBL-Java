package Registros;

import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import java.util.Date;
public class RegistroAluguel {
    private int tempo;
    private double valor;

    public static void registrarAluguel(Automovel automovel, Cliente cliente, Vendedor vendedor, Date dataAluguel, double valorAluguel) {
        automovel = automovel;
        cliente = cliente;
        vendedor = vendedor;
        dataAluguel = dataAluguel;
        valorAluguel = valorAluguel;
    }
}
