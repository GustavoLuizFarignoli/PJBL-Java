package Automoveis;
import Automoveis.Automovel;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
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
    public static void menuCarro(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Carro******" +
                "1. Registrar venda\n" +
                "2. Registrar aluguel\n" +
                "3. Cadastrar carro\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op){
            case 1:
                // Metodo de registrar venda
                break;
            case 2:
                // metodo de registrar aluguel
                break;
            case 3:
                // metodo de cadastrar carro
                break;
        }
    }
}