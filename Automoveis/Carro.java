package Automoveis;
import Estoque.Carros;

import Estoque.Serializador;
import Excecao.IdentificadorDuplicado;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Carro extends Automovel {
    private int n_portas;
    private int horsepower;

    public Carro(String marca, String modelo, int idade, double kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int n_portas, int horsepower) throws HeadlessException {
        super(marca, modelo, idade, kilomt, tipo, combustivel, qt_marcha, cor, chassi, tamanhotanque, valor);
        this.n_portas = n_portas;
        this.horsepower = horsepower;
    }

    public void setHorsepower(int horsepower){
        this.horsepower = horsepower;
    }

    @Override
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
                        "\nNúmero do Portas: " + this.n_portas+
                        "\nHorse Power: "+this.horsepower;
    }

    @Override
    public void depreciar(int idade, double valor) {
        double taxa;
        if (idade <= 3){
            taxa = 0.05;
        } else if (idade <= 8){
            taxa = 0.07;
        } else {
            taxa = 0.12;
        }
        valor -= valor * taxa;
        System.out.println("O valor do carro seria R$" + valor);
    }
    public static void menuCarro(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                ******Menu Carro******
                1. Cadastra carro
                2. Editar carro
                3. Excluir carro
                4. Visualizar carro
                5. Ver todos os carros
                6. Calcular a desvalorização
                7. Finalizar""");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op){
            case 1:
                // Metodo de cadastrar carro
                teclado.nextLine();
                boolean valido = false;

                Carros cadastro;
                try {
                    cadastro = (Carros) Serializador.ler("Carros");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

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
                        idade = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    }catch (NumberFormatException e){
                        System.out.println("Por favor responda apenas com números inteiros ");
                    }catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamento.");
                    }
                }

                valido = false;
                double kilomt = 0;
                while (!valido){
                    System.out.println("Digite a quilometragem:  ");
                    try{
                        kilomt = Double.parseDouble(teclado.nextLine());
                        valido = true;
                    }catch (NumberFormatException e){
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
                        System.out.println("""
                                ******Menu Tipo******
                                1. Harchs
                                2. Sedans
                                3. SUVs
                                4. Picapes
                                5. Utilitários""");

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
                    }catch (NumberFormatException e){
                        System.out.println("Por favor reponda apenas com números inteiros");
                    }catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                String cor = "";
                valido = false;
                while (!valido){
                    try {
                        System.out.println("Digite a cor do carro: ");
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
                    }catch (NumberFormatException e){
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
                    }catch (NumberFormatException e){
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
                    }catch (NumberFormatException e){
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e){
                        System.out.println("Erro Desconhecido, tente novamente.");
                    }
                }

                valido = false;
                String chassi = "";

                while (!valido){
                    try {
                        System.out.println("Digite o serial do chassi do carro: ");
                        chassi = teclado.nextLine();
                        if (chassi.length() == 17) {
                            chassi = chassi.toUpperCase();
                            Carro id = cadastro.findCarro(chassi);
                            if (id == null){
                                valido = true;
                            } else {
                                throw new IdentificadorDuplicado();
                            }
                        } else {
                            System.out.println("Digite um serial válido, 17 letras no total.");
                        }
                    } catch (IdentificadorDuplicado e){
                        System.out.println("Este Chassi já está cadastro e não pode ser cadastrado novamente");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
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
                // metodo de editar
                Carros editar;
                try {
                    editar = (Carros) Serializador.ler("Carros");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException();
                }

                teclado.nextLine();
                System.out.println("Qual o chassi do carro que deseja editar: ");
                chassi = teclado.nextLine();
                chassi = chassi.toUpperCase();

                Carro edit =editar.findCarro(chassi);
                if (edit == null){
                    System.out.println("Não foi possivel encontar nenhum carro com esse chassi");
                }else { // Código editar carro
                    System.out.println(edit);
                    System.out.println("===========================");

                    System.out.println("Digite a nova marca (ou deixa vazio para manter): ");
                    marca = teclado.nextLine();
                    if (!marca.isEmpty()){
                        edit.setMarca(marca);
                    }

                    valido = false;
                    while(!valido){
                        try {
                            System.out.println("Digite o modelo do carro (ou deixa vazio para manter):   ");
                            modelo = teclado.nextLine();
                            if (!modelo.isEmpty()){
                                edit.setModelo(modelo);
                            }
                            valido = true;
                        } catch (Exception e){
                            System.out.println("Erro Desconhecido, tente novamnte");
                        }
                    }

                    valido = false;
                    while (!valido){
                        String age;
                        System.out.println("Digite a idade do carro (ou deixa vazio para manter):  ");
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
                        System.out.println("Digite o quilometragem do carro(ou deixa vazio para manter): ");
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
                            System.out.println("Digite o combustivel do carro(ou deixa vazio para manter): ");
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
                    while (!valido){
                        try {
                            System.out.println("""
                                    ******Menu Tipo******
                                    1. Harchs
                                    2. Sedans
                                    3. SUVs
                                    4. Picapes
                                    5. Utilitários
                                    6. Manter mesmo tipo""");
                            System.out.println("Digite o tipo desejado: ");
                            op = Integer.parseInt(teclado.nextLine());
                            if(op != 0){
                                switch (op){
                                    case 1->{
                                        edit.setTipo("Harchs");
                                        valido = true;
                                    }
                                    case 2 ->{
                                        edit.setTipo("Sedans");
                                        valido = true;
                                    }
                                    case 3 -> {
                                        edit.setTipo("SUVs");
                                        valido = true;
                                    }
                                    case 4 ->{
                                        edit.setTipo("Picapes");
                                        valido = true;
                                    }
                                    case 5 -> {
                                        edit.setTipo("Utilitários");
                                        valido = true;
                                    }
                                    case 6 -> {
                                        valido = true;
                                    }
                                    default -> System.out.println("Digite um valor válido");
                                }
                                }
                            }catch (Exception e){
                                 System.out.println("Erro desconhecido, tente novamente");
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
                            System.out.println("Digite a cor do carro(ou deixa vazio para manter): ");
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
                        String preco;
                        System.out.println("Digite o valor do carro(ou deixa em vazio para manter): ");
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
                    while(!valido){
                        String potencia;
                        System.out.println("Digite o horse power do carro(ou deixa vazio para manter): ");
                        potencia = teclado.nextLine();
                        if (!potencia.isEmpty()){
                            try {
                                horsepower = Integer.parseInt(potencia);
                                edit.setHorsepower(horsepower);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        } else {
                            valido = true;
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

                    valido = false;
                    while(!valido){
                        String portas;
                        System.out.println("Digite o número de portas do carro(ou deixa vazio para manter): ");
                        portas = teclado.nextLine();
                        if (!portas.isEmpty()){
                            try {
                                qt_marcha = Integer.parseInt(portas);
                                edit.setTamanhotanque(qt_marcha);
                                valido = true;
                            }catch (Exception e){
                                System.out.println("Digite apenas números inteiros");
                            }
                        } else {
                            valido = true;
                        }
                    }
                    try {
                        Serializador.gravar("Carros",editar);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Alterações realizadas com sucesso!");
                }


                break;
            case 3:
                // metodo de excluir carro
                Carros excluir;
                try {
                    excluir = (Carros) Serializador.ler("Carros");
                }catch (IOException | ClassNotFoundException e){
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual é o chassi do carro que deseja excluir: ");
                chassi = teclado.nextLine();

                Carro ex = excluir.findCarro(chassi.toUpperCase());
                if (ex == null){
                    System.out.println("Não foi possivel encontrar um carro com essa chassi");
                }else {
                    excluir.removeCarro(ex);
                    try {
                        Serializador.gravar("Carros", excluir);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Carro excluido com sucesso");
                }
                break;
            case 4:
                // vizualizar carro especifico
                Carros visualizar;
                try {
                    visualizar=(Carros) Serializador.ler("Carros");
                }catch (IOException | ClassNotFoundException e){
                    throw new RuntimeException(e);
                }
                teclado.nextLine();
                System.out.println("Qual o chassi do carro que deseja visualizar: ");
                chassi = teclado.nextLine();

                Carro v = visualizar.findCarro(chassi.toUpperCase());
                if(v==null){
                    System.out.println("Não foi possivel encontrar um carro com esse chassi");
                }else {
                    System.out.println("===========================");
                    System.out.println(v);
                    System.out.println("===========================");
                }
                break;
            case 5:
                // visualizar todos os carros
                Carros vertodos;

                try {
                    vertodos = (Carros) Serializador.ler("Carros");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                vertodos.viewcarro();

                break;

            case 6:
                Carros simular;
                try {
                    simular = (Carros) Serializador.ler("Carros");
                }catch (IOException | ClassNotFoundException e){
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o chassi do carro que deseja simular: ");
                chassi = teclado.nextLine();

                Carro s = simular.findCarro(chassi.toUpperCase());
                if (s==null){
                    System.out.println("Não foi possivel encontrar um carro com esse chassi");
                }else {
                    valido = false;
                    idade = 0;
                    while (!valido){
                        try {
                            System.out.println("Digite quantos anos deseja envelhecer este carro: ");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                        }catch (NumberFormatException e){
                            System.out.println("Por favor reponda apenas com números inteiros");
                        }catch (Exception e){
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }
                    s.depreciar(s.getIdade()+idade,s.getValor());
                }
                break;
            case 7:
                // Finalizar
                break;
            case 8://remover na hora da apresentação
                Carros carros1 = new Carros();

                Carro c1 = new Carro("Toyota","Corolla", 0, 1052,"Sedan","Elétrico", 4,"Cinza","4AN15ASE2Z8K44325",45,30000,5,67);
                Carro c2 = new Carro("Fiat","Uno", 11, 120100,"Sedan","Combustão", 5,"Vermelho Escarlate","840N15NDDWJXA2726",60,40000,5,73);

                carros1.addCarro(c1);
                carros1.addCarro(c2);

                try {
                    Serializador.gravar("Carros", carros1);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;

        }
    }
}