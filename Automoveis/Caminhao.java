package Automoveis;
import Estoque.Caminhoes;
import Estoque.Carros;
import Estoque.Serializador;
import Registros.RegistroAluguel;
import Registros.RegistroVenda;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public static void menuCaminhao(int op) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Caminhão******\n" +
                "1. Registrar venda\n" +
                "2. Registrar aluguel\n" +
                "3. Cadastrar caminhão\n" +
                "4. Calcular a desvalorização\n" +
                "5. Finalizar");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        boolean valido;
        String combustivel = null;
        String tipo = null;
        double kilomt = 0;
        int idade = 0;
        String modelo = null;
        String marca = null;
        switch (op) {
            case 1:
                // Metodo de registrar venda
                break;
            case 2:
                // metodo de registrar aluguel
                break;
            case 3:
                // metodo de cadastrar caminhão
                teclado.nextLine();
                valido = false;

                marca = "";
                while (marca.length() == 0) {
                    System.out.println("Digite a Marca do caminhão: ");
                    marca = teclado.nextLine();
                }
                marca = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();

                modelo = "";
                while (modelo.length() == 0) {
                    System.out.println("Digite o modelo do caminhão: ");
                    modelo = teclado.nextLine();
                }
                modelo = modelo.substring(0, 1).toUpperCase() + modelo.substring(1).toLowerCase();

                valido = false;
                idade = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a idade deste caminhão: ");
                        idade = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                    }

                valido = false;
                kilomt = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a quilometragem deste caminhão: ");
                        kilomt = Double.parseDouble(teclado.nextLine());
                        valido = true;
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                combustivel = "";
                while (!valido) {
                    try {
                        System.out.println("Qual dos seguintes tipo: Elétrico; Combustão ou Híbrido, seu caminhão pertence: ");
                        combustivel = teclado.nextLine();
                        if (combustivel.equalsIgnoreCase("elétrico") || combustivel.equalsIgnoreCase("combustão")  || combustivel.equalsIgnoreCase("híbrido")) {
                            combustivel = combustivel.substring(0, 1).toUpperCase() + combustivel.substring(1).toLowerCase();
                            valido = true;
                        } else {
                            System.out.print("Digite um dos seguintes tipo: Elétrico; Combustão ou Híbrido");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                tipo = "";
                while (!valido) {
                    try {
                        System.out.println("******Menu Tipo******\n" +
                                "1. 3/4 ou VUC\n" +
                                "2. Toco\n" +
                                "3. Truck\n" +
                                "4. Cavalo Mecânico Simples\n" +
                                "5. Cavalo Mecânico Trucado\n" +
                                "6. Conjunto Carreta\n" +
                                "7. Bitrem\n" +
                                "8. Rodotrem\n");
                        System.out.print("Digite o tipo desejado: ");
                        op = Integer.parseInt(teclado.nextLine());
                        switch (op) {
                            case 1:
                                tipo = "3/4 ou VUC";
                                valido = true;
                                break;
                            case 2:
                                tipo = "Toco";
                                valido = true;
                                break;
                            case 3:
                                tipo = "Truck";
                                valido = true;
                                break;
                            case 4:
                                tipo = "Cavalo Mecânico Simples";
                                valido = true;
                                break;
                            case 5:
                                tipo = "Cavalo Mecânico Trucado";
                                valido = true;
                                break;
                            case 6:
                                tipo = "Conjunto Carreta";
                                valido = true;
                                break;
                            case 7:
                                tipo = "Bitrem";
                                valido = true;
                                break;
                            case 8:
                                tipo = "Rodotrem";
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
                    break;
                }

                valido = false;
                int qt_marcha = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a quantidade de marchas deste caminhão: ");
                        qt_marcha = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String cor = "";
                while (!valido) {
                    try {
                        System.out.println("Digite a cor deste caminhão: ");
                        cor = teclado.nextLine();
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int tamanhotanque = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o tamanho do tanque deste caminhão: ");
                        tamanhotanque = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String chassi = "";
                String serial = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o serial do chassi deste caminhão: ");
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

                valido = false;
                double valor = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o valor deste caminhão: ");
                        valor = Double.parseDouble(teclado.nextLine());
                        valido = true;
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                int n_eixos = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o número de eixos deste caminhão: ");
                        n_eixos = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

        Caminhoes cadastro;
        try {
            cadastro = (Caminhoes) Serializador.ler("Caminhoes");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Caminhao c = new Caminhao(marca, modelo, idade, (int) kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor, n_eixos);

        cadastro.addCaminhao(c);
        try {
            Serializador.gravar("Caminhoes", cadastro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




