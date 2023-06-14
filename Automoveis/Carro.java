package Automoveis;
import Estoque.Carros;
import Automoveis.Automovel;
import Estoque.Motos;
import Estoque.Serializador;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Carro extends Automovel {
    private int n_portas;
    private int horsepower;

    public Carro(String marca, String modelo, int idade, long kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int n_portas, int horsepower) throws HeadlessException {
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
        System.out.println("******Menu Carro******\n" +
                "1. Cadastra carro \n" +
                "2. Editar carro\n" +
                "3. Excluir carro\n" +
                "4. Visualizar carro\n" +
                "5. Ver todos os carros\n" +
                "6. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op){
            case 1:
                // Metodo de cadastrar carro
                teclado.nextLine();
                boolean valido = false;

                String marca = "";
                while (marca.length()==0){
                    System.out.println("Digite a marca do carro: ");
                    marca = teclado.nextLine();
                }
                marca = marca.substring(0,1).toUpperCase() + marca.substring(1).toLowerCase();

                String modelo = "";
                while (modelo.length()==0){
                    System.out.println("Digite o modelo do carro: ");
                    modelo = teclado.nextLine();
                }
                modelo = modelo.substring(0,1).toUpperCase() + modelo.substring(1).toLowerCase();

                valido = false;
                int idade = 0;
                while (!valido){
                    System.out.println("Digite a idade do Carro: ");
                    try {
                        idade = teclado.nextInt();
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor responda apenas com números inteiros ");
                    }catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamento.");
                    }
                }

                valido = false;
                long kilomt = 0;
                while (!valido){
                    System.out.println("Digite a quilometragem:  ");
                    try{
                        kilomt = teclado.nextLong();
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor responda apneas com números");
                    }catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String combustivel= "";
                teclado.nextLine();
                while (!valido){
                    try {
                        System.out.println("Qual dos seguintes tipo: Elétrico; Combustão ou Híbrido, seu carro pertence: ");
                        combustivel = teclado.nextLine();
                        if (combustivel.equalsIgnoreCase("elétrico") || combustivel.equalsIgnoreCase("combustão")  || combustivel.equalsIgnoreCase("híbrido")) {
                            combustivel = combustivel.substring(0, 1).toUpperCase() + combustivel.substring(1).toLowerCase();
                            valido = true;
                        }
                        else {
                            System.out.println("Erro. Digite um dos seguintes tipo: Elétrico; Combustão ou Híbrido\n");
                        }
                    }catch (Exception e){
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                String tipo = "";
                while (!valido) {
                    try {
                        System.out.println("******Menu Tipo******\n" +
                                "1. Harchs\n" +
                                "2. Sedans\n" +
                                "3. SUVs\n" +
                                "4. Picapes\n" +
                                "5. Utilitários\n");
                        System.out.println("Digite o tipo desejado: ");
                        op = Integer.parseInt(teclado.nextLine());
                        switch (op) {
                            case 1:
                                tipo = "Harchs";
                                valido = true;
                                break;
                            case 2:
                                tipo = "Sedans";
                                valido = true;
                                break;
                            case 3:
                                tipo = "SUVs";
                                valido = true;
                                break;
                            case 4:
                                tipo = "Picapes";
                                valido = true;
                                break;
                            case 5:
                                tipo = "Utilitários";
                                valido = true;
                                break;
                            default:
                                System.out.println("Digite um valor válido");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }
                valido = false;
                int qt_marcha = 0;
                while (!valido){
                    try {
                        System.out.println("Digite a quantidade de marcha: ");
                        qt_marcha = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor reponda apenas com números inteiros");
                    }catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String cor = "";
                while (cor.length()==0){
                    System.out.println("Digite a cor do carro: ");
                    cor = teclado.nextLine();
                }
                cor = cor.substring(0,1).toUpperCase() + cor.substring(1).toLowerCase();

                valido = false;
                double valor = 0;
                while (!valido){
                    try {
                        System.out.println("Digite o valor do carro: ");
                        valor = Double.parseDouble(teclado.nextLine());
                        valido = true;
                    } catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int horsepower = 0;
                while (!valido){
                    try {
                        System.out.println("Digite o horse power do carro: ");
                        horsepower = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente.");
                    }
                }

                valido = false;
                int tamanhotanque = 0;
                while (!valido){
                    try{
                        System.out.println("Digite o tamanho do tanque do carro: ");
                        tamanhotanque = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente.");
                    }
                }

                valido = false;
                int n_portas = 0;
                while (!valido){
                    try{
                        System.out.println("Digite o número de portas do carro: ");
                        n_portas = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    }catch (InputMismatchException e){
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente.");
                    }
                }

                valido = false;
                String chassi = "";
                String serial = "";
                while (!valido){
                    try {
                        System.out.println("Digite o serial do chassi do carro: ");
                        serial = teclado.nextLine();
                        if (serial.length() == 17) {
                            chassi = teclado.nextLine();
                            valido = true;
                        } else {
                            System.out.println("Digite um serial válido, 17 letras no total.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                Carros cadastro;
                try {
                    cadastro = (Carros) Serializador.ler("Carros");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Carro c = new Carro(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor, n_portas, horsepower);


                cadastro.addCarro(c);
                try {
                    Serializador.gravar("Carros", cadastro);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
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