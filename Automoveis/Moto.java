package Automoveis;

import Automoveis.Automovel;

public class Moto extends Automovel {
    private int cilindradas;

    public Moto(String marca, String modelo, int idade, int kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor) {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
    }

    @Override
    public void depreciar() {

    }
}
