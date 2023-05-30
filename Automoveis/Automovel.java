package Automoveis;

import Formulario.FormRefactored;

import javax.swing.*;
import java.awt.*;

public abstract class Automovel extends Formulario.FormRefactored {
    private String marca;
    private String modelo;
    private int idade;
    private int kilomt;
    private String tipo;
    private String combustivel;
    private int qt_marcha;
    private String cor;
    private String chassi;
    private int tamanhotanque;
    private double valor;

    public abstract void depreciar();

    public void envelhecer(int anos){
        this.idade += anos;
    }
}
