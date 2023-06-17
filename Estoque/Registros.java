package Estoque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import Automoveis.Automovel;
import Registros.Registro;
import Registros.RegistroVenda;
import Registros.RegistroAluguel;

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

    public void viewRegistroVenda(){
        for (Registro r : this.registros){
            if(r instanceof RegistroVenda){
                System.out.println("===========================");
                System.out.println(r);
            }
        }
        System.out.println("===========================");
    }
    public void viewRegistroAluguel(){
        for (Registro r : this.registros){
            if(r instanceof RegistroAluguel){
                System.out.println("===========================");
                System.out.println(r);
            }
        }
        System.out.println("===========================");
    }

    public Registro findaluguel(Automovel a){
        for (Registro r : this.registros){
            if(Objects.equals(r.getAutomovel().getChassi(), a.getChassi())){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Registro> getCarros() {
        return registros;
    }
}
