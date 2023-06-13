package Estoque;

import Automoveis.Carro;
import java.io.Serializable;
import java.util.ArrayList;

public class Carros implements Serializable {
    private ArrayList<Carro> carros = new ArrayList<>();

    public Carros(){carros = new ArrayList<>();};

    public void addCarro(Carro carros) {this.carros.add(carros);}
    public void removeCarro(Carro carros){this.carros.remove(carros);}

}
