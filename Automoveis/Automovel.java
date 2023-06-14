package Automoveis;
import java.awt.*;

public abstract class Automovel extends Formulario.FormRefactored {
    private String marca;
    private String modelo;
    private int idade;
    private double kilomt;
    private String tipo;
    private String combustivel;
    private int qt_marcha;
    private String cor;
    private String chassi;
    private int tamanhotanque;
    private double valor;

    public Automovel(String marca, String modelo, int idade, double kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor) throws HeadlessException {
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

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilomt() {
        return kilomt;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public int getQt_marcha() {
        return qt_marcha;
    }

    public String getCor() {
        return cor;
    }

    public int getTamanhotanque() {
        return tamanhotanque;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setKilomt(double kilomt) {
        this.kilomt = kilomt;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setQt_marcha(int qt_marcha) {
        this.qt_marcha = qt_marcha;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setTamanhotanque(int tamanhotanque) {
        this.tamanhotanque = tamanhotanque;
    }

    public void vender(Automovel automovel){
        // retirar produto do estoque
        // criar registro de vendas
        // dar comissão ao vendedor
        // escrever alterações no estoque
        // escrever alterações nos registros
    }

}
