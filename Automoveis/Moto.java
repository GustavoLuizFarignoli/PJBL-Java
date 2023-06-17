package Automoveis;
import Estoque.Motos;
import Estoque.Serializador;
import Excecao.IdentificadorDuplicado;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Moto extends Automovel{
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    private int cilindradas;

    public Moto(String marca, String modelo, int idade, double kilomt, String tipo, String combustivel, int qt_marcha, String cor, String chassi, int tamanhotanque, double valor, int  cilindradas) throws HeadlessException {
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
        System.out.println("O valor do moto seria R$" + valor);
    }
    public static void menuMoto(int op) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                ******Menu Moto******
                1. Cadastrar moto
                2. Editar moto
                3. Excluir moto
                4. Visualizar moto
                5. Ver todas as motos
                6. Calcular a desvalorização
                7. Finalizar
                """);
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 8:
                Moto c1 = new Moto("Triumph", "Tiger", 3, 48000, "Esportiva", "Combustão", 6, "Verde Oliva", "3CAA83MAX18XK5481", 20, 90000,900);
                Moto c2 = new Moto("Kawasaki", "Z1000", 2, 10000, "Esportiva", "Combustão", 5, "Preta e Verde", "43756AC42F8PL6304", 15, 74800, 500);

                Motos m1 = new Motos();
                m1.addMoto(c1);
                m1.addMoto(c2);
                try {
                    Serializador.gravar("Motos", m1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                // Finalizar menu
                break;
            case 6:
                // metodo de depreciar
                Motos simular;
                try {
                    simular = (Motos) Serializador.ler("Motos");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual chassi da moto que deseja simular: ");
                String chassi;
                chassi = teclado.nextLine();

                Moto s = simular.findMoto(chassi.toUpperCase());
                if (s == null) {
                    System.out.println("Não foi possivel encotrar a moto com esse chassi");
                } else {
                    boolean valido = false;
                    int idade = 0;
                    while (!valido) {
                        try {
                            System.out.println("Digite quantos anos deseja envelhecer esta moto: ");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor reponda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }
                    s.depreciar(s.getIdade() + idade, s.getValor());
                }

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
            System.out.println("Qual o Serial da Moto que deseja excluir ?");
            chassi = teclado.nextLine().toUpperCase();

            Moto ex = excluir.findMoto(chassi);
            if (ex == null) {
                System.out.println("Não foi possivel encontrar nenhuma moto com este Serial");
            } else {
                excluir.removeMoto(ex);
                try {
                    Serializador.gravar("Motos", excluir);
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

            Motos cadastro;
            try {
                cadastro = (Motos) Serializador.ler("Motos");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

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


            int idade = 0;
            while (!valido) {
                try {
                    System.out.println("Digite a idade desta moto: ");
                    idade = Integer.parseInt(teclado.nextLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor responda apenas com números inteiros");
                } catch (Exception e) {
                    System.out.println("Erro Desconhecido, tente novamente");
                }
            }

            valido = false;
            double kilomt = 0;

            while (!valido) {
                try {
                    System.out.println("Digite a quilometragem desta moto: ");
                    kilomt = Double.parseDouble(teclado.nextLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor responda apenas com números inteiros");
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
                } catch (NumberFormatException e) {
                    System.out.println("Por favor responda apenas com números inteiros");
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
                } catch (NumberFormatException e) {
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
                } catch (NumberFormatException e) {
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
                } catch (NumberFormatException e) {
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
                        Moto id = cadastro.findMoto(chassi);
                        if (id == null) {
                            valido = true;
                        } else {
                            throw new IdentificadorDuplicado();
                        }
                    }
                } catch (IdentificadorDuplicado e) {
                    System.out.println("Este Chassi já está cadastro e não pode ser cadastrado novamente");
                } catch (Exception e) {
                    System.out.println("Erro Desconhecido, tente novamente");
                }
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

                System.out.println("Digite a nova marca (ou deixa vazio para manter): ");
                marca = teclado.nextLine();
                if (!marca.isEmpty()) {
                    edit.setMarca(marca);
                }

                valido = false;
                while (!valido) {
                    try {
                        System.out.println("Digite o novo modelo da moto (ou deixa vazio para manter): ");
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
                    String age;
                    System.out.println("Digite a idade da moto (ou deixa vazio para manter):  ");
                    age = teclado.nextLine();
                    if (!age.isEmpty()) {
                        try {
                            idade = Integer.parseInt(age);
                            edit.setIdade(idade);
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        }
                    } else {
                        valido = true;
                    }
                }

                valido = false;
                while (!valido) {
                    String km;
                    System.out.println("Digite o quilometragem do moto(ou deixa vazio para manter): ");
                    km = teclado.nextLine();
                    if (!km.isEmpty()) {
                        try {
                            kilomt = Double.parseDouble(km);
                            edit.setKilomt(kilomt);
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        }
                    } else {
                        valido = true;
                    }
                }

                valido = false;
                while (!valido) {
                    try {
                        System.out.println("Digite o combustivel da moto(ou deixa vazio para manter): ");
                        combustivel = teclado.nextLine();
                        if (!combustivel.isEmpty()) {
                            edit.setCombustivel(combustivel);
                        }
                        valido = true;
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
                                10. Manter mesmo tipo
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
                                case 10 -> {
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
                    String preco;
                    System.out.println("Digite o valor da moto(ou deixa em vazio para manter): ");
                    preco = teclado.nextLine();
                    if (!preco.isEmpty()) {
                        try {
                            valor = Double.parseDouble(preco);
                            edit.setValor(valor);
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Digite apenas números inteiros");
                        }
                    } else {
                        valido = true;
                    }
                }

                valido = false;
                while (!valido) {
                    String cili;
                    System.out.println("Digite a cilindrada desta moto (ou deixa vazio para manter): ");
                    cili = teclado.nextLine();
                    if (!cili.isEmpty()) {
                        try {
                            cilindradas = Integer.parseInt(cili);
                            edit.setCilindradas(cilindradas);
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Digite apenas números inteiros");
                        }
                    } else {
                        valido = true;
                    }
                }

                valido = false;
                while (!valido) {
                    String marchas;
                    System.out.println("Digite a quantidade de marcha(ou deixa vazio para manter): ");
                    marchas = teclado.nextLine();
                    if (!marchas.isEmpty()) {
                        try {
                            qt_marcha = Integer.parseInt(marchas);
                            edit.setQt_marcha(qt_marcha);
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Digite apenas números inteiros");
                        }
                    } else {
                        valido = true;
                    }
                }

                valido = false;
                while (!valido) {
                    try {
                        System.out.println("Digite a cor da moto(ou deixa vazio para manter): ");
                        cor = teclado.nextLine();
                        if (cor.matches(".*\\d+.*")) {
                            System.out.println("Não digite números");
                        } else if (!cor.isEmpty()) {
                            cor = cor.substring(0, 1).toUpperCase() + cor.substring(1).toLowerCase();
                            edit.setCor(cor);
                            valido = true;
                        } else {
                            valido = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido, tenta novamente");
                    }
                }

                valido = false;
                while (!valido) {
                    String tanque;
                    System.out.println("Digite o tamanha do tanque da moto(ou deixa vazio para manter): ");
                    tanque = teclado.nextLine();
                    if (!tanque.isEmpty()) {
                        try {
                            tamanhotanque = Integer.parseInt(tanque);
                            edit.setTamanhotanque(tamanhotanque);
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Digite apenas números inteiros");
                        }
                    } else {
                        valido = true;
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
                "\nModelo: " + getModelo() +
                "\nIdade: " + getIdade() +
                "\nQuilometragem: " + getKilomt() +
                "\nTipo: " + getTipo() +
                "\nCombustível: " + getCombustivel() +
                "\nQuantidade de marchas: " + getQt_marcha() +
                "\nCor: " + getCor() +
                "\nChassi: " + getChassi() +
                "\nTamanho do tanque: " + getTamanhotanque() +
                "\nCilindradas: " + getCilindradas() +
                "\nValor: " + getValor();
    }
}
