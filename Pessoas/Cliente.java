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
        return "Cliente{Nome: " + getNome()+
                " CPF: " + getCpf() +
                " CEP: " + getCep() +
                " Idade: " + getIdade() +
                " Telefone: +55 (41) " + getTelefone();
    }

    public static void menuCliente(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Cliente******\n" +
                "1. Casdastrar cliente\n" +
                "2. Editar cliente\n" +
                "3. Excluir cliente\n" +
                "4. Visualizar cliente\n" +
                "5. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                // Metodo de cadastrar
                teclado.nextLine(); //Preciso dessa linha pois o nextint não "consome" o /n
                boolean valido = false;

                System.out.println("Digite o Nome deste Cliente: ");
                String nome = teclado.nextLine();
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

                String cpf = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o CPF deste Cliente (apenas os números): ");
                        cpf = teclado.nextLine(); // Não faz Validação
                        if (cpf.length() != 11 ) { // Transformar em Exception ?
                            System.out.println("Número de CPF Inválido, Ele deve conter 11 digitos");
                        } else {
                            valido = true;
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
                int numtelefone = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o Telefone deste Cliente sem DDD: ");
                        numtelefone = Integer.parseInt(teclado.nextLine());
                        if (Integer.toString(numtelefone).length() < 8 || Integer.toString(numtelefone).length() > 9) { // Transformar em Exception ?
                            System.out.println("Número de Telefone Inválido, Ele deve conter entre 8 a 9 digitos");
                        } else {
                            valido = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }
                String telefone = "55 " + numtelefone;

                valido = false;
                int cep = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o CEP deste Cliente (apenas os números): ");
                        cep = Integer.parseInt(teclado.nextLine());
                        if (Integer.toString(cep).length() != 8 ) { // Transformar em Exception ?
                            System.out.println("Número de CEP Inválido, Ele deve conter 8 digitos");
                        } else {
                            valido = true;

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
                    System.out.println(cadastro);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                Cliente c = new Cliente(nome,cpf, idade,telefone,Integer.toString(cep));

                cadastro.addCliente(c);
                try {
                    Serializador.gravar("Clientes",cadastro);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                // Metodo editar
                break;
            case 3:
                // Metodo excluir
                break;
            case 4:
                // metodo Visualizar
                Clientes visualizar;
                try {
                    visualizar = (Clientes) Serializador.ler("Clientes");
                    System.out.println(visualizar.getlista());
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                break;
        }
    }
}
