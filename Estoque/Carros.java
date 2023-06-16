package Estoque;

import Automoveis.Carro;
import Pessoas.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Carros implements Serializable{
    private ArrayList<Carro> carros = new ArrayList<>();

    public Carros() {
        carros = new ArrayList<>();
    }

    public void addCarro(Carro carros) {
        this.carros.add(carros);
    }
    public void removeCarro(Carro carros) {
        this.carros.remove(carros);
    }

    public Carro findCarro(String chassi){
        Carro carros = null;
        for (Carro r : this.carros){
            if (Objects.equals(r.getChassi(), chassi)){
                carros = r;
            }
        }
        return carros; //Quem for usar tem que tratar do resultado nulo
    }

    public void viewcarro(){
        for (Carro c : this.carros){
            System.out.println("===========================");
            System.out.println(c);
        }
        System.out.println("===========================");
    }
    public ArrayList<Carro> getCarros() {
        return carros;
    }
}
