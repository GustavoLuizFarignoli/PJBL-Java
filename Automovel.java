public abstract class Automovel {
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

    public Automovel(String marca, String modelo, int idade, int kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor) {
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
    public abstract void depreciar();

    public void envelhecer(int anos){
        this.idade += anos;
    }
}
