package Pessoas;

import Estoque.Clientes;
import Estoque.Serializador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente extends Pessoa implements Serializable {

    public Cliente(String nome, String cpf, int idade, String telefone, String cep) {
        super(nome, cpf, idade, telefone, cep);
    }
    public void comprarAutomavel(String nome, String telefone, double valor, String modelo, String marca){

    }

    public void alugarAutomavel(String nome,String telefone, double valor, int tempo, String modelo, String marca){

    }
    //Metódo comprar Automoveis.Carro
    //Metódo alugar Automoveis.Carro


    @Override
    public String toString() {
        return "Nome: " + getNome()+
                "\nCPF: " + getCpf() +
                "\nCEP: " + getCep() +
                "\nIdade: " + getIdade() +
                "\nTelefone: +55 (41) " + getTelefone();
    }

    public static void menuCliente(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Cliente******\n" +
                "1. Casdastrar cliente\n" +
                "2. Editar cliente\n" +
                "3. Excluir cliente\n" +
                "4. Visualizar cliente\n" +
                "5. Ver todos os clientes\n" +
                "6. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                // Metodo de cadastrar
                teclado.nextLine(); //Preciso dessa linha, pois o nextint não "consome" o /n
                boolean valido = false;

                String nome = "";
                while (nome.length() == 0){
                    System.out.println("Digite o Nome deste Cliente: ");
                    nome = teclado.nextLine();
                }
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

                String cpf = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o CPF deste Cliente: ");
                        cpf = teclado.nextLine();
                        if (validarCPF(cpf)) { // Transformar em Exception ?
                            valido = true;
                            cpf = cpfformat(cpf);
                        } else {
                            System.out.println("Número de CPF Inválido");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro de formato");
                    } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int idade = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a idade deste Cliente: ");
                        idade = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }


                valido = false;
                String numtelefone = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o Telefone deste Cliente sem DDD: ");
                        numtelefone = teclado.nextLine();
                        if (numtelefone.length() < 8 || numtelefone.length() > 9) { // Transformar em Exception ?
                            System.out.println("Número de Telefone Inválido, Ele deve conter entre 8 a 9 digitos");
                        } else {
                            valido = true;
                            numtelefone = formatcell(numtelefone);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String cep = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o CEP deste Cliente: ");
                        cep = teclado.nextLine();
                        if (validarCEP(cep)) {
                            valido = true;
                            cep = formatcep(cep);
                        } else {
                            System.out.println("Número de CEP Inválido");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                Clientes cadastro;
                try {
                    cadastro = (Clientes) Serializador.ler("Clientes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                Cliente c = new Cliente(nome,cpf, idade,numtelefone,cep);

                cadastro.addCliente(c);
                try {
                    Serializador.gravar("Clientes",cadastro);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                // Metodo editar
                Clientes editar;
                try {
                    editar = (Clientes) Serializador.ler("Clientes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Cliente que deseja editar ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Cliente edit = editar.findcliente(cpf);
                if (edit == null){
                    System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
                } else {
                    //Código editar
                    System.out.println(edit);
                    System.out.println("===========================");

                    System.out.println("Digite o novo nome (ou deixe em branco para manter o valor atual):");
                    nome = teclado.nextLine();
                    if(!nome.isEmpty()){
                        edit.setNome(nome);
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a nova idade (ou digite 0 para manter o valor atual):");
                            idade = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if(idade != 0){
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
                            System.out.println("Digite o novo Telefone deste Cliente sem DDD: ");
                            numtelefone = teclado.nextLine();
                            if (numtelefone.length() < 8 || numtelefone.length() > 9) { // Transformar em Exception ?
                                if (numtelefone.isEmpty()){
                                    valido = true;
                                } else {
                                    System.out.println("Número de Telefone Inválido, Ele deve conter entre 8 a 9 digitos");
                                }
                            } else {
                                valido = true;
                                numtelefone = formatcell(numtelefone);
                                edit.setTelefone(numtelefone);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o novo CEP deste Cliente (ou deixe em branco para manter o valor atual):  ");
                            cep = teclado.nextLine();
                            if (validarCEP(cep)) {
                                valido = true;
                                edit.setCep(formatcep(cep));
                            } else if (cep.isEmpty()) {
                                valido = true;
                            } else {
                                System.out.println("Número de CEP Inválido");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    try {
                        Serializador.gravar("Clientes",editar);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
            case 3:
                // Metodo excluir
                Clientes excluir;
                try {
                    excluir = (Clientes) Serializador.ler("Clientes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Cliente que deseja excluir ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Cliente ex = excluir.findcliente(cpf);
                if (ex == null){
                    System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
                } else {
                    excluir.removeCliente(ex);
                    try {
                        Serializador.gravar("Clientes",excluir);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Cliente Excluido com sucesso");
                }

                break;
            case 4:
                // metodo Visualizar
                Clientes visualizar;
                try {
                    visualizar = (Clientes) Serializador.ler("Clientes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Cliente que deseja visualizar ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Cliente v = visualizar.findcliente(cpf);
                if (v == null){
                    System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
                } else {
                    System.out.println(v);
                }
                break;
            case 5:
                Clientes vertodos;
                try {
                    vertodos = (Clientes) Serializador.ler("Clientes");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                vertodos.viewclientes();

                break;
            case 6:
                break;
            case 7:
                //Opção de Debug, deve ser removida posteriormente

                Clientes cadastro1 = new Clientes();
                Cliente c1 = new Cliente("Guga","089.927.489-73",18,"99119-2406","80110-030");

                cadastro1.addCliente(c1);
                try {
                    Serializador.gravar("Clientes",cadastro1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }
}
