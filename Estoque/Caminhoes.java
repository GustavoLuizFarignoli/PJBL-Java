package Estoque;
import Automoveis.Caminhao;
import Pessoas.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Caminhoes implements Serializable{
    private ArrayList<Caminhao> caminhoes = new ArrayList<>();

    public Caminhoes() {
        caminhoes = new ArrayList<>();
    }

    public void addCaminhao(Caminhao caminhoes) {
        this.caminhoes.add(caminhoes);
    }
    public void removeCaminhao(Caminhao caminhoes) {
        this.caminhoes.remove(caminhoes);
    }

    public Caminhao findCaminhao(String chassi){
        Caminhao caminhoes = null;
        for (Caminhao c : this.caminhoes){
            if (Objects.equals(c.getChassi(), chassi)){
                caminhoes = c;
            }
        }
        return caminhoes;
    }

    public void viewcaminhao(){
        for (Caminhao c : this.caminhoes){
            System.out.println("===========================");
            System.out.println(c);
        }
        System.out.println("===========================");
    }

}

