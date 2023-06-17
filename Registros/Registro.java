package Registros;

import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;

import java.io.Serializable;

public class Registro implements Serializable {
    private Automovel automovel;
    private Cliente cliente;

    public Registro(Automovel automovel, Cliente cliente) {
        this.automovel = automovel;
        this.cliente = cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}