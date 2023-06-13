package Automoveis;
import java.awt.*;

public abstract class Automovel extends Formulario.FormRefactored {
    private String marca;
    private String modelo;
    private int idade;
    private long kilomt;
    private String tipo;
    private String combustivel;
    private int qt_marcha;
    private String cor;
    private String chassi;
    private int tamanhotanque;
    private double valor;

    public Automovel(String marca, String modelo, int idade, long kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor) throws HeadlessException {
        this.marca = marca;
        this.modelo = modelo;
        this.idade = idade;
        this.kilomt = kilomt;
        this.tipo = tipo;
        this.combustivel = combustivel;
        this.qt_marcha = qt_marcha;
        this.cor = cor;
        this.chassi = chassi;
        this.tamanhotanque = tamanhotanque;
        this.valor = valor;
    }

    public abstract void depreciar(int anos);

    public void envelhecer(int anos){
        this.idade += anos;
    }

    public int getIdade() {
        return idade;
    }

    public String getChassi() {
        return chassi;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void vender(Automovel automovel){
        // retirar produto do estoque
        // criar registro de vendas
        // dar comissão ao vendedor
        // escrever alterações no estoque
        // escrever alterações nos registros
    }

}
