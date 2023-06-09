package Estoque;

import Pessoas.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Clientes implements Serializable {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Clientes() {
        clientes = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    public void removeCliente(Cliente cliente) {
       this.clientes.remove(cliente);
    }

    public Cliente findcliente(String cpf){
        Cliente cliente = null;
        for (Cliente c : this.clientes){
            if (Objects.equals(c.getCpf(), cpf)){
                cliente = c;
            }
        }
        return cliente; //Quem for usar tem que tratar do resultado nulo
    }

    public void viewclientes(){
        for (Cliente c : this.clientes){
            System.out.println("===========================");
            System.out.println(c);
        }
        System.out.println("===========================");
    }

    public ArrayList<Cliente> getlista() {
        return clientes;
    }
}
