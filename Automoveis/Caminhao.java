package Automoveis;
import Estoque.Caminhoes;
import Estoque.Motos;
import Estoque.Serializador;
import Excecao.IdentificadorDuplicado;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Caminhao extends Automovel {

    public void setEixos(int n_eixos) {
        this.n_eixos = n_eixos;
    }
    private int n_eixos;

    public Caminhao(String marca, String modelo, int idade, double kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int n_eixos) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.n_eixos = n_eixos;
    }

    @Override
    public void depreciar(int idade, double valor) {
        double taxa = 0;
        if (this.n_eixos <= 4) {
            if (idade <= 8) {
                taxa = 0.02;
            } else if (idade <= 12) {
                taxa = 0.06;
            } else {
                taxa = 0.13;
            }
        } else if (this.n_eixos <= 9) {
            if (idade <= 6) {
                taxa = 0.04;
            } else if (idade <= 9) {
                taxa = 0.09;
            } else {
                taxa = 0.16;
            }
        }
        valor -= valor * taxa;
        System.out.println("O valor do caminhão seria R$" + valor);
    }

    public String toString() {
        return
                "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nIdade: " + getIdade() +
                "\nQuilometragem: " + getKilomt() +
                "\nTipo: " + getTipo() +
                "\nCombustivel: " + getCombustivel() +
                "\nNúmero de marcha: " + getQt_marcha() +
                "\nCor: " + getCor() +
                "\nChassi: " + getChassi() +
                "\nTamanho do Tanque: " + getTamanhotanque() + "L" +
                "\nValor: " + getValor()+
                "\nNúmero de eixos: " + this.n_eixos;
    }


    public static void menuCaminhao(int op) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                ******Menu Caminhão******
                1. Cadastrar caminhão
                2. Editar caminhão
                3. Procurar Caminhão
                4. Visualizar Caminhões
                5. Excluir Caminhão
                6. Calcular a desvalorização
                7. Finalizar""");
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
                // metodo de cadastrar caminhão
                teclado.nextLine();
                valido = false;

                Caminhoes cadastro;
                try {
                    cadastro = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

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
                    } catch (NumberFormatException e) {
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
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
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

                valido = false;
                tipo = "";
                while (!valido) {
                    try {
                        System.out.println("""
                                ******Menu Tipo******
                                1. 3/4 ou VUC
                                2. Toco
                                3. Truck
                                4. Cavalo Mecânico Simples
                                5. Cavalo Mecânico Trucado
                                6. Conjunto Carreta
                                7. Bitrem
                                8. Rodotrem""");
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
                int qt_marcha = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a quantidade de marchas deste caminhão: ");
                        qt_marcha = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                String cor = "";
                valido = false;
                while (!valido){
                    try {
                        System.out.println("Digite a cor do caminhão: ");
                        cor = teclado.nextLine();
                        if (cor.matches(".*\\d+.*")){
                            System.out.println("Não digite números");
                        } else if (!cor.isEmpty()){
                            valido = true;
                        }
                    }catch (Exception e){
                        System.out.println("Erro desconhecido, tenta novamente");
                    }
                }
                cor = cor.substring(0,1).toUpperCase() + cor.substring(1).toLowerCase();

                valido = false;
                int tamanhotanque = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o tamanho do tanque deste caminhão: ");
                        tamanhotanque = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String chassi = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o serial do chassi deste caminhão: ");
                        chassi = teclado.nextLine();
                        if (chassi.length() == 17) {
                            chassi = chassi.toUpperCase();
                            Caminhao id = cadastro.findCaminhao(chassi);
                            if (id == null) {
                                valido = true;
                            } else {
                                throw new IdentificadorDuplicado();
                            }
                        }
                    } catch (IdentificadorDuplicado e){
                        System.out.println("Este Chassi já está cadastro e não pode ser cadastrado novamente");
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
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                Caminhao c = new Caminhao(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor, n_eixos);

                cadastro.addCaminhao(c);
                try {
                    Serializador.gravar("Caminhoes", cadastro);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                //método editar caminhão
                Caminhoes editar;
                try {
                    editar = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Digite o serial do chassi do caminhão à ser editada: ");
                chassi = teclado.nextLine();

                Caminhao edit = editar.findCaminhao(chassi);
                if (edit == null) {
                    System.out.println("Não foi possivel encontrar nenhum com este serial");
                } else {
                    //Código editar
                    System.out.println(edit);
                    System.out.println("===========================");

                    System.out.println("Digite a nova marca (ou deixa vazio para manter):");
                    marca = teclado.nextLine();
                    if (!marca.isEmpty()) {
                        edit.setMarca(marca);
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o novo modelo do caminhão (ou deixa vazio para manter): ");
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
                    while (!valido){
                        String age;
                        System.out.println("Digite a idade do caminhão (ou deixa vazio para manter):  ");
                        age = teclado.nextLine();
                        if (!age.isEmpty()){
                            try {
                                idade = Integer.parseInt(age);
                                edit.setIdade(idade);
                                valido = true;
                            }catch (NumberFormatException e){
                                System.out.println("Por favor responda apenas com números inteiros");
                            }
                        }else {
                            valido = true;
                        }
                    }

                    valido = false;
                    while (!valido){
                        String km;
                        System.out.println("Digite o quilometragem do caminhão(ou deixa vazio para manter): ");
                        km = teclado.nextLine();
                        if (!km.isEmpty()){
                            try {
                                kilomt = Double.parseDouble(km);
                                edit.setKilomt(kilomt);
                                valido = true;
                            }catch (NumberFormatException e){
                                System.out.println("Por favor responda apenas com números inteiros");
                            }
                        }else {
                            valido = true;
                        }
                    }
                    valido = false;
                    while (!valido){
                        try {
                            System.out.println("Digite o combustivel do caminhão(ou deixa vazio para manter): ");
                            combustivel = teclado.nextLine();
                            if(!combustivel.isEmpty()){
                                edit.setCombustivel(combustivel);
                            }
                            valido = true;
                        }catch (Exception e){
                            System.out.println("Erro desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("""
                                    ******Menu Tipo******
                                    "1. 3/4 ou VUC
                                    "2. Toco
                                    "3. Truck
                                    "4. Cavalo Mecânico Simples
                                    "5. Cavalo Mecânico Trucado
                                    "6. Conjunto Carreta
                                    "7. Bitrem
                                    "8. Rodotrem
                                    "9. Manter mesmo tipo
                                    """);
                            System.out.print("Digite o tipo desejado: ");
                            op = Integer.parseInt(teclado.nextLine());
                            if (op != 0) {
                                switch (op) {
                                    case 1 -> {
                                        edit.setTipo("3/4 ou VUC");
                                        valido = true;
                                    }
                                    case 2 -> {
                                        edit.setTipo("Toco");
                                        valido = true;
                                    }
                                    case 3 -> {
                                        edit.setTipo("Truck");
                                        valido = true;
                                    }
                                    case 4 -> {
                                        edit.setTipo("Cavalo Mecânico Simples");
                                        valido = true;
                                    }
                                    case 5 -> {
                                        edit.setTipo("Cavalo Mecânico Trucado");
                                        valido = true;
                                    }
                                    case 6 -> {
                                        edit.setTipo("Conjunto Carreta");
                                        valido = true;
                                    }
                                    case 7 -> {
                                        edit.setTipo("Bitrem");
                                        valido = true;
                                    }
                                    case 8 -> {
                                        edit.setTipo("Rodotrem");
                                        valido = true;
                                    }
                                    case 9 -> {
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
                    while(!valido){
                        String preco;
                        System.out.println("Digite o valor do caminhão(ou deixa em vazio para manter): ");
                        preco = teclado.nextLine();
                        if (!preco.isEmpty()){
                            try {
                                valor = Double.parseDouble(preco);
                                edit.setValor(valor);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        } else {
                            valido = true;
                        }
                    }

                    valido = false;
                    while (!valido) {
                        String eixos;
                        System.out.println("Digite a quantidade de eixos (ou deixa vazio para manter): ");
                        eixos = teclado.nextLine();
                        if (!eixos.isEmpty()){
                            try {
                                n_eixos = Integer.parseInt(eixos);
                                edit.setEixos(n_eixos);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        }else {
                            valido = true;
                        }
                    }

                    valido = false;
                    while(!valido){
                        String marchas;
                        System.out.println("Digite a quantidade de marcha(ou deixa vazio para manter): ");
                        marchas = teclado.nextLine();
                        if (!marchas.isEmpty()){
                            try {
                                qt_marcha = Integer.parseInt(marchas);
                                edit.setQt_marcha(qt_marcha);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        } else {
                            valido = true;
                        }
                    }

                    valido = false;
                    while (!valido){
                        try {
                            System.out.println("Digite a cor do caminhão(ou deixa vazio para manter): ");
                            cor = teclado.nextLine();
                            if (cor.matches(".*\\d+.*")){
                                System.out.println("Não digite números");
                            } else if (!cor.isEmpty()){
                                cor = cor.substring(0,1).toUpperCase() + cor.substring(1).toLowerCase();
                                edit.setCor(cor);
                                valido = true;
                            } else {
                                valido = true;
                            }
                        }catch (Exception e){
                            System.out.println("Erro desconhecido, tenta novamente");
                        }
                    }

                    valido = false;
                    while(!valido){
                        String tanque;
                        System.out.println("Digite o tamanha do tanque do carro(ou deixa vazio para manter): ");
                        tanque = teclado.nextLine();
                        if (!tanque.isEmpty()){
                            try {
                                tamanhotanque = Integer.parseInt(tanque);
                                edit.setTamanhotanque(tamanhotanque);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        } else {
                            valido = true;
                        }
                    }

                    try {
                        Serializador.gravar("Caminhoes", editar);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Alterações realizadas com sucesso!");

                }
                break;
            case 3:
                //metódo visualizar caminhão especifico
                Caminhoes visualizar;
                try {
                    visualizar = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o Chassi do caminhão que deseja visualizar ?");
                chassi = teclado.nextLine();

                Caminhao v = visualizar.findCaminhao(chassi.toUpperCase());
                if (v == null){
                    System.out.println("Não foi possivel encontrar um Caminhão com este chassi");
                } else {
                    System.out.println("===========================");
                    System.out.println(v);
                    System.out.println("===========================");
                }
                break;
            case 4:
                //método ver todos caminhões
                Caminhoes vertodos;

                try {
                    vertodos = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                vertodos.viewcaminhao();

                break;
            case 5:
                //remover
                Caminhoes excluir;
                try {
                    excluir = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o Chassi do caminhão que deseja excluir ?");
                chassi = teclado.nextLine();

                Caminhao ex = excluir.findCaminhao(chassi.toUpperCase());
                if (ex == null){
                    System.out.println("Não foi possivel encontrar um Caminhão com este chassi");
                } else {
                    excluir.removeCaminhao(ex);
                    try {
                        Serializador.gravar("Caminhoes",excluir);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Caminhão Excluido com sucesso");
                }
                break;
            case 6:
                //calcular desvalorização
                Caminhoes simular;
                try {
                    simular = (Caminhoes) Serializador.ler("Caminhoes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o Chassi do caminhão que deseja simular a desvalorização ?");
                chassi = teclado.nextLine();

                Caminhao s = simular.findCaminhao(chassi.toUpperCase());
                if (s == null){
                    System.out.println("Não foi possivel encontrar um Caminhão com este chassi");
                } else {

                    valido = false;
                    idade = 0;
                    while (!valido) {
                        try {
                            System.out.println("Digite quantos anos deseja envelhecer este caminhão: ");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }
                    s.depreciar(s.getIdade()+idade,s.getValor());
                }
                break;
            case 7:
                //finalizar
                break;
            case 8:
                //debug
                Caminhoes cadastro1 = new Caminhoes();

                Caminhao c1 = new Caminhao("Toyota", "Caminhão", 12, 3033.3, "Toco", "Elétrico", 3, "Verde", "9BWHE21JX24060831", 60, 30000, 4);
                Caminhao c2 = new Caminhao("Volvo ", "Volvo FH", 0, 41658.79, "Truck", "Combustão", 5, "cinza", "8MWA4AXYAA17K9867", 70, 472000.50, 6);

                cadastro1.addCaminhao(c1);
                cadastro1.addCaminhao(c2);
                try {
                    Serializador.gravar("Caminhoes", cadastro1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}




