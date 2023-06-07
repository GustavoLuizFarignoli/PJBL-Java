package Pessoas;
import Pessoas.Pessoa;
import java.util.Scanner;

public class Cliente extends Pessoa {

    public Cliente(int id, String nome, String cpf, int idade, String telefone, String cep) {
        super(id, nome, cpf, idade, telefone, cep);
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
                "4. Atualizar cliente\n" +
                "5. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                // Metodo de cadastrar
                break;
            case 2:
                // Metodo editar
                break;
            case 3:
                // Metodo excluir
                break;
            case 4:
                // metodo atualizar
                break;
            case 5:
                break;
        }
    }
}
