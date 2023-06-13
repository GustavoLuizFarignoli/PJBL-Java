package Automoveis;
import Automoveis.Automovel;
import java.awt.*;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Moto extends Automovel implements Serializable {
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
                "3. Cadastrar moto\n" +
                "4. Calcular a desvalorização\n" );
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
                    teclado.nextLine();
                    boolean valido = false;

                    String marca = "";
                    while (marca.length() == 0){
                        System.out.println("Digite a Marca da moto: ");
                        marca = teclado.nextLine();
                    }
                    marca = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();

                    String modelo = "";
                    while (modelo.length() == 0){
                        System.out.println("Digite o modelo da moto: ");
                        modelo = teclado.nextLine();
                    }
                    modelo = modelo.substring(0, 1).toUpperCase() + modelo.substring(1).toLowerCase();

                    valido = false;
                    int idade = 0;
                    while (!valido) {
                        try {
                            System.out.println("Digite a idade desta moto: ");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    double kilomt = 0;
                    while (!valido) {
                        try {
                            System.out.println("Digite a kilometragem desta moto: ");
                            kilomt = Double.parseDouble(teclado.nextLine());
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    String combustivel = "";
                    while (!valido){
                        try {
                        System.out.println("Digite o combustível da moto: ");
                        combustivel = teclado.nextLine();
                        if (combustivel.toLowerCase() == "elétrico"  || combustivel.toLowerCase() == "combustão" || combustivel.toLowerCase() == "híbrido") {
                            combustivel = combustivel.substring(0, 1).toUpperCase() + combustivel.substring(1).toLowerCase();
                            valido = true;
                        }
                        else {
                            System.out.print("Digite um dos seguintes tipo: Elétrico; Combustão ou Híbrido");
                        }
                        }catch (Exception e){
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    String tipo = "";
                    while (!valido){
                        try {
                            System.out.println("******Menu Tipo******\n" +
                                    "1. Big Trail\n" +
                                    "2. Custom\n" +
                                    "3. Esportiva\n" +
                                    "4. Naked\n" +
                                    "5. Scooter\n" +
                                    "6. Street\n" +
                                    "7. Touring\n" +
                                    "8. Trail\n" +
                                    "9. Off-Road\n" );
                            System.out.print("Digite o tipo desejado: ");
                            op = Integer.parseInt(teclado.nextLine());
                            switch (op){
                                case 1:
                                    tipo = "Big Trail";
                                    valido = true;
                                    break;
                                case 2:
                                    tipo = "Custom";
                                    valido = true;
                                    break;
                                case 3:
                                    tipo = "Esportiva";
                                    valido = true;
                                    break;
                                case 4:
                                    tipo = "Naked";
                                    valido = true;
                                    break;
                                case 5:
                                    tipo = "Scooter";
                                    valido = true;
                                    break;
                                case 6:
                                    tipo = "Street";
                                    valido = true;
                                    break;
                                case 7:
                                    tipo = "Touring";
                                    valido = true;
                                    break;
                                case 8:
                                    tipo = "Trail";
                                    valido = true;
                                    break;
                                case 9:
                                    tipo = "Off-Road";
                                    valido = true;
                                    break;
                                default:
                                    System.out.println("Digite um valor válido");
                            }
                        }catch (Exception e){
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    // valor
                    // especifico da classe
                    break;
            case 4:
                // metodo depreciar

                break;
            }
    }
}