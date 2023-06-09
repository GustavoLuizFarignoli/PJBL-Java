package Estoque;

import Pessoas.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Clientes() {
        clientes = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    public  void removeCliente(Cliente cliente) {
       this.clientes.remove(cliente);
    }

    public ArrayList<Cliente> getlista() {
        return clientes;
    }
}
