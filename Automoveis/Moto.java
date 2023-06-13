package Automoveis;
import Automoveis.Automovel;
import Estoque.Clientes;
import Estoque.Motos;
import Estoque.Serializador;
import Pessoas.Cliente;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Moto extends Automovel implements Serializable {
    private int cilindradas;

    public Moto(String marca, String modelo, int idade, long kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int  cilindradas) throws HeadlessException {
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
    public static void menuMoto(int op) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Moto******\n" +
                "1. Registrar venda\n" +
                "2. Registrar aluguel\n" +
                "3. Cadastrar moto\n" +
                "4. Calcular a desvalorização\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
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
                while (marca.length() == 0) {
                    System.out.println("Digite a Marca da moto: ");
                    marca = teclado.nextLine();
                }
                marca = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();

                String modelo = "";
                while (modelo.length() == 0) {
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
                long kilomt = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a quilometragem desta moto: ");
                        kilomt = Long.parseLong(teclado.nextLine());
                        valido = true;
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                String combustivel = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o combustível da moto: ");
                        combustivel = teclado.nextLine();
                        if (combustivel.toLowerCase().equals("elétrico") || combustivel.toLowerCase() == "combustão" || combustivel.toLowerCase() == "híbrido") {
                            combustivel = combustivel.substring(0, 1).toUpperCase() + combustivel.substring(1).toLowerCase();
                            valido = true;
                        } else {
                            System.out.print("Digite um dos seguintes tipo: Elétrico; Combustão ou Híbrido");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                String tipo = "";
                while (!valido) {
                    try {
                        System.out.println("""
                                ******Menu Tipo******
                                1. Big Trail
                                2. Custom
                                3. Esportiva
                                4. Naked
                                5. Scooter
                                6. Street
                                7. Touring
                                8. Trail
                                9. Off-Road
                                """);
                        System.out.print("Digite o tipo desejado: ");
                        op = Integer.parseInt(teclado.nextLine());
                        switch (op) {
                            case 1 -> {
                                tipo = "Big Trail";
                                valido = true;
                            }
                            case 2 -> {
                                tipo = "Custom";
                                valido = true;
                            }
                            case 3 -> {
                                tipo = "Esportiva";
                                valido = true;
                            }
                            case 4 -> {
                                tipo = "Naked";
                                valido = true;
                            }
                            case 5 -> {
                                tipo = "Scooter";
                                valido = true;
                            }
                            case 6 -> {
                                tipo = "Street";
                                valido = true;
                            }
                            case 7 -> {
                                tipo = "Touring";
                                valido = true;
                            }
                            case 8 -> {
                                tipo = "Trail";
                                valido = true;
                            }
                            case 9 -> {
                                tipo = "Off-Road";
                                valido = true;
                            }
                            default -> System.out.println("Digite um valor válido");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                double valor = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o valor desta moto: ");
                        valor = Double.parseDouble(teclado.nextLine());
                        valido = true;
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tente novamente");
                    }
                }

                valido = false;
                int cilindradas = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a cilindrada desta moto: ");
                        cilindradas = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                    valido = false;
                    int qt_marcha = 0;
                    while (!valido) {
                        try {
                            System.out.println("Digite o número de marchas desta moto: ");
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
                                System.out.println("Digite a cor desta moto: ");
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
                                    System.out.println("Digite o tamanho do tanque desta moto: ");
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
                                        System.out.println("Digite o serial do chassi desta moto: ");
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

                                    Motos cadastro;
                                    try {
                                        cadastro = (Motos) Serializador.ler("Motos");
                                    } catch (IOException | ClassNotFoundException e) {
                                        throw new RuntimeException(e);
                                    }

                                    Moto c = new Moto(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor, cilindradas);

                                    cadastro.addMoto(c);
                                    try {
                                        Serializador.gravar("Motos", cadastro);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                        case 4:
                            // metodo depreciar
                            break;
                                
                            }
                        }
}