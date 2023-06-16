package Automoveis;
import Estoque.Clientes;
import Automoveis.Automovel;
import Estoque.Motos;
import Estoque.Serializador;
import Pessoas.Cliente;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Moto extends Automovel implements Serializable {
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    private int cilindradas;

    public Moto(String marca, String modelo, int idade, long kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int  cilindradas) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.cilindradas = cilindradas;
    }

    @Override
    public void depreciar(int anos, double valor) {
        double Taxa = 0;
        if (getIdade() <= 3){
            Taxa = 0.03;
        } else if (getIdade() <= 5){
            Taxa = 0.05;
        } else {
            Taxa = 0.10;
        }
        valor -= valor * Taxa;
        System.out.println("O valor do caminhão seria R$" + valor);
    }
    public static void menuMoto(int op) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Moto******\n" +
                "1. Cadastrar moto\n" +
                "2. Editar moto\n" +
                "3. Excluir moto\n" +
                "4. Visualizar moto\n" +
                "5. Ver todas as motos\n" +
                "6. Calcular a desvalorização\n" +
                "7. Finalizar\n");
                System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 7:
                // Finalizar menu
                break;
            case 6:
                // metodo de depreciar
                break;
            case 5:
                // Metodo de Ver todas as motos
                Motos vertodos;
                try {
                    vertodos = (Motos) Serializador.ler("Motos");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                vertodos.viewMotos();

                break;
            case 3:
                // Metodo de excluir moto
                Motos excluir;
                try {
                    excluir = (Motos) Serializador.ler("Motos");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                String chassi;
                System.out.println("Qual o Serial da Moto que deseja excluir ?");
                chassi = teclado.nextLine().toUpperCase();

                Moto ex = excluir.findMoto(chassi);
                if (ex == null){
                    System.out.println("Não foi possivel encontrar nenhuma moto com este Serial");
                } else {
                    excluir.removeMoto(ex);
                    try {
                        Serializador.gravar("Motos",excluir);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Moto Excluida com sucesso");
                }
                break;
            case 4:
                // metodo de visualizar moto
                Motos visualizar;
                try {
                    visualizar = (Motos) Serializador.ler("Motos");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o Serial do chassi da moto que deseja visualizar ?");
                chassi = teclado.nextLine().toUpperCase();

                Moto m = visualizar.findMoto(chassi);
                if (m == null) {
                    System.out.println("Não foi possivel encontrar nenhuma moto com esse Serial");
                } else {
                    System.out.println(m);
                }
                break;
            case 1:
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
                        System.out.println("Qual dos seguintes tipo: Elétrico; Combustão ou Híbrido, sua moto pertence: ");
                        combustivel = teclado.nextLine();
                        if (combustivel.equalsIgnoreCase("elétrico") || combustivel.equalsIgnoreCase("combustão") || combustivel.equalsIgnoreCase("híbrido")) {
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
                chassi = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o serial do chassi desta moto: ");
                        chassi = teclado.nextLine();
                        if (chassi.length() == 17) {
                            chassi = chassi.toUpperCase();
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
            case 2:
                // metodo editar
                Motos editar;
                try {
                    editar = (Motos) Serializador.ler("Motos");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Digite o serial do chassi da moto à ser editada: ");
                chassi = teclado.nextLine();

                Moto edit = editar.findMoto(chassi);
                if (edit == null) {
                    System.out.println("Não foi possivel encontrar nenhuma com este serial");
                } else {
                    //Código editar
                    System.out.println(edit);
                    System.out.println("===========================");

                    System.out.println("Digite a nova marca (ou deixe em branco para manter o valor atual):");
                    marca = teclado.nextLine();
                    if (!marca.isEmpty()) {
                        edit.setMarca(marca);
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o novo modelo da moto (ou deixe em branco para manter o valor atual): ");
                            modelo = teclado.nextLine();
                            if (!modelo.isEmpty()) {
                                edit.setModelo(modelo);
                                valido = true;
                            } else {
                                valido = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido");
                        }
                    }


                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a idade desta moto (ou digite 0 para manter valor atual): ");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if (idade != 0) {
                                edit.setIdade(idade);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a quilometragem desta moto (ou digite 0 para manter valor atual): ");
                            kilomt = Long.parseLong(teclado.nextLine());
                            valido = true;
                            if (kilomt != 0) {
                                edit.setKilomt(kilomt);
                            }
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Para qual dos seguintes tipo: Elétrico; Combustão ou Híbrido, você deseja alterar sua moto (Ou deixe em branco para manter valor atual): ");
                            combustivel = teclado.nextLine();
                            if (!combustivel.isEmpty()) {
                                if (combustivel.equalsIgnoreCase("elétrico") || combustivel.equalsIgnoreCase("combustão") || combustivel.equalsIgnoreCase("híbrido")) {
                                    edit.setCombustivel(combustivel);
                                    valido = true;
                                }
                            } else {
                                System.out.print("Digite um dos seguintes tipo: Elétrico; Combustão ou Híbrido");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
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
                            if (op != 0) {
                                switch (op) {
                                    case 1 -> {
                                        edit.setTipo("Big Trail");
                                        valido = true;
                                    }
                                    case 2 -> {
                                        edit.setTipo("Custom");
                                        valido = true;
                                    }
                                    case 3 -> {
                                        edit.setTipo("Esportiva");
                                        valido = true;
                                    }
                                    case 4 -> {
                                        edit.setTipo("Naked");
                                        valido = true;
                                    }
                                    case 5 -> {
                                        edit.setTipo("Scooter");
                                        valido = true;
                                    }
                                    case 6 -> {
                                        edit.setTipo("Street");
                                        valido = true;
                                    }
                                    case 7 -> {
                                        edit.setTipo("Touring");
                                        valido = true;
                                    }
                                    case 8 -> {
                                        edit.setTipo("Trail");
                                        valido = true;
                                    }
                                    case 9 -> {
                                        edit.setTipo("Off-Road");
                                        valido = true;
                                    }
                                    default -> System.out.println("Digite um valor válido");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o valor desta moto (ou digite 0 para manter valor atual): ");
                            valor = Double.parseDouble(teclado.nextLine());
                            valido = true;
                            if (valor != 0) {
                                edit.setValor(valor);
                            }
                        } catch (Exception e) {
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a cilindrada desta moto (ou digite 0 para manter valor atual): ");
                            cilindradas = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if (cilindradas != 0) {
                                edit.setCilindradas(cilindradas);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o número de marchas desta moto (ou digite 0 para manter valor atual): ");
                            qt_marcha = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if (qt_marcha != 0) {
                                edit.setQt_marcha(qt_marcha);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a cor desta moto (ou deixe em branco para manter valor atual): ");
                            cor = teclado.nextLine();
                            valido = true;
                            if (!cor.isEmpty()) {
                                edit.setCor(cor);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o tamanho do tanque desta moto (ou digite 0 para manter valor atual): ");
                            tamanhotanque = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if (tamanhotanque != 0) {
                                edit.setTamanhotanque(tamanhotanque);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    try {
                        Serializador.gravar("Motos", editar);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
        }
    }

    public int getCilindradas() {
        return cilindradas;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca() +
                "Modelo: " + getModelo() +
                "Idade: " + getIdade() +
                "Quilometragem: " + getKilomt() +
                "Tipo: " + getTipo() +
                "Combustível: " + getCombustivel() +
                "Quantidade de marchas: " + getQt_marcha() +
                "Cor: " + getCor() +
                "Chassi: " + getChassi() +
                "Tamanho do tanque: " + getTamanhotanque() +
                "Cilindradas: " + getCilindradas() +
                "Valor: " + getValor();
    }
}
