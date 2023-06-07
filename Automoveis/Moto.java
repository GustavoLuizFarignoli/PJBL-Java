package Automoveis;
import Automoveis.Automovel;
import java.awt.*;
import java.util.Scanner;

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
    public static void menuMoto(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Moto******\n" +
                "1. Registrar venda\n" +
                "2. Registrar aluguel\n" +
                "3. Cadastrar moto\n" );
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
                // metodo de cadastrar moto
                break;
        }
    }
}