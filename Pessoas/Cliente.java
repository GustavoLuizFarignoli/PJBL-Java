package Pessoas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf, int idade, String telefone, String cep) {
        super(nome, cpf, idade, telefone, cep);
    }
    public void comprarAutomavel(String nome, String telefone, double valor, String modelo, String marca){

    }

    public void alugarAutomavel(String nome,String telefone, double valor, int tempo, String modelo, String marca){

    }
    //Metódo comprar Automoveis.Carro
    //Metódo alugar Automoveis.Carro

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
                boolean valido = false;

                System.out.println("Digite o Nome deste Cliente: ");
                String nome = teclado.nextLine();

                int cpf = 0;
                while (!valido) {
                    System.out.println("Digite o CPF deste Cliente (apenas os números): ");
                    try {
                        cpf = teclado.nextInt();
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int idade = 0;
                while (!valido) {
                    System.out.println("Digite a idade deste Cliente: ");
                    try {
                        idade = teclado.nextInt();
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
                    System.out.println("Digite o Telefone deste Cliente sem DDD: ");
                    try {
                        numtelefone = teclado.nextInt();
                        if (Integer.toString(numtelefone).length() < 8 || Integer.toString(numtelefone).length() > 9) { // Transformar em Exception ?
                            System.out.println("Número de Digitos invalído, Digite um valor entre 8 a 9 digitos");
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
                    System.out.println("Digite o CEP deste Cliente (apenas os números): ");
                    try {
                        cep = teclado.nextInt();
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                Cliente c = new Cliente(nome, Integer.toString(cpf), idade,telefone,Integer.toString(cep));
                //Incluir No Banco de Dados

                break;
            case 2:
                // Metodo editar
                break;
            case 3:
                // Metodo excluir
                break;
            case 4:
                // metodo Visualizar
                break;
            case 5:
                break;
        }
    }
}
