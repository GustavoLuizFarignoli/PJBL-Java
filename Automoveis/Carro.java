package Automoveis;

import Automoveis.Automovel;

import javax.swing.*;
import java.awt.*;

public class Carro extends Automovel {
    private int n_portas;
    private int horsepower;

    public Carro(String marca, String modelo, int idade, int kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int n_portas, int horsepower) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.n_portas = n_portas;
        this.horsepower = horsepower;
    }

    @Override
    public void depreciar(int anos) {
        double taxa;
        envelhecer(anos);
        if (getIdade() <= 3){
            taxa = 0.05;
        } else if (getIdade() <= 8){
            taxa = 0.07;
        } else {
            taxa = 0.12;
        }
        setValor(getValor() * (1-taxa));
    }
}
