package Automoveis;

import java.awt.*;

public class Caminhao extends Automovel{
    private int n_eixos;

    public Caminhao(String marca, String modelo, int idade, int kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int n_eixos) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.n_eixos = n_eixos;
    }

    @Override
    public void depreciar(int anos) {
        double Taxa = 0;
        envelhecer(anos);
        if (this.n_eixos<=4){
            if (getIdade() <= 8){
                Taxa = 0.02;
            } else if (getIdade() <= 12){
                Taxa = 0.06;
            } else {
                Taxa = 0.13;
            }
        }
        else if (this.n_eixos<=9){
            if (getIdade() <= 6){
                Taxa = 0.04;
            } else if (getIdade() <= 9){
                Taxa = 0.09;
            } else {
                Taxa = 0.16;
            }
        }
        setValor(getValor() * Taxa);
    }
}

