package Estoque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import Automoveis.Carro;
import Registros.Registro;

public class Registros implements Serializable {
    private ArrayList<Registro> registros = new ArrayList<>();

    public Registros() {
    }

    public void addRegistro(Registro registro) {
        this.registros.add(registro);
    }
    public void removeRegistro(Registro registro) {
        this.registros.remove(registro);
    }

    public void viewRegistro(){
        for (Registro r : this.registros){
            System.out.println("===========================");
            System.out.println(r);
        }
        System.out.println("===========================");
    }
    public ArrayList<Registro> getCarros() {
        return registros;
    }
}
