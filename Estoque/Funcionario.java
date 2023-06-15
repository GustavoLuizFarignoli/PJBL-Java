package Estoque;

import Pessoas.Vendedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Funcionario implements Serializable {
    private ArrayList<Vendedor> funcionarios = new ArrayList<>();

    public Funcionario() {
        funcionarios = new ArrayList<>();
    }

    public void addFuncionario(Vendedor funcionario) {
        this.funcionarios.add(funcionario);
    }
    public void removeFuncionario(Vendedor funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public Vendedor findfuncionario(String cpf){
        Vendedor vendedor = null;
        for (Vendedor v : this.funcionarios){
            if (Objects.equals(v.getCpf(), cpf)){
                vendedor = v;
            }
        }
        return vendedor; //Quem for usar tem que tratar do resultado nulo
    }

    public void viewfuncionarios(){
        for (Vendedor v : this.funcionarios){
            System.out.println("===========================");
            System.out.println(v);
        }
        System.out.println("===========================");
    }

    public void viewpagamentos(){
        for (Vendedor v : this.funcionarios){
            System.out.println("===========================");
            v.Pagamento();
        }
        System.out.println("===========================");
    }

    public ArrayList<Vendedor> getlista() {
        return funcionarios;
    }
}
