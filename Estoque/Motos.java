package Estoque;

import Automoveis.Moto;
import Pessoas.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Motos implements Serializable{
    private ArrayList<Moto> motos = new ArrayList<>();

    public Motos() {
        motos = new ArrayList<>();
    }

    public void addMoto(Moto motos) {
        this.motos.add(motos);
    }
    public void removeMoto(Moto motos) {
        this.motos.remove(motos);
    }

    public Moto findMoto(String chassi){
        Moto motos = null;
        for (Moto m : this.motos){
            if (Objects.equals(m.getChassi(), chassi)){
                motos = m;
            }
        }
        return motos; //Quem for usar tem que tratar do resultado nulo
    }
    public void viewMotos(){
        for (Moto m : this.motos){
            System.out.println("===========================");
            System.out.println(m);
        }
        System.out.println("===========================");
    }

    public ArrayList<Moto> getlista() {
        return motos;
    }

    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }
}