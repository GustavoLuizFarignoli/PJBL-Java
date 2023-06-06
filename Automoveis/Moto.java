package Automoveis;

import Automoveis.Automovel;

import java.awt.*;

public class Moto extends Automovel {
    private int cilindradas;

    public Moto(String marca, String modelo, int idade, int kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int cilindradas) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.cilindradas = cilindradas;
    }

    @Override
    public void depreciar(int anos) {
        double Taxa = 0;
        envelhecer(anos);
        if (getIdade() <= 3){
            Taxa = 0.03;
        } else if (getIdade() <= 5){
            Taxa = 0.05;
        } else {
            Taxa = 0.10;
        }
        setValor(getValor() * Taxa);

    }
}