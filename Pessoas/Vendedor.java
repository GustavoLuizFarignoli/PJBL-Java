package Pessoas;
import Pessoas.Pessoa;

import java.util.Scanner;

public class Vendedor extends Pessoa {
    private int salario;
    private double comissao;
    private int qtvendas;

    public Vendedor(int id, String nome, String cpf, int idade, String telefone, String cep, int salario, double comissao, int qtvendas) {
        super(id, nome, cpf, idade, telefone, cep);
        this.salario = salario;
        this.comissao = comissao;
        this.qtvendas = qtvendas;
    }

    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao, double valor) {
        if (valor >= 100000){
            this.comissao = valor * 0.03;
        }
        if (valor >= 50000){
            this.comissao = valor * 0.08;
        }
        if (valor >= 25000){
            this.comissao = valor * 0.13;
        }
    }

    public void Pagamento(){
        double pagamento = this.salario + this.comissao;
        System.out.println("O Funcionário " + getNome() + "Deve receber um total de " + pagamento );
        this.comissao = 0;
    }
    public static void menuVendedor(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Vendedor******\n" +
                "1. Casdastrar vendedor\n" +
                "2. Editar vendedor\n" +
                "3. Excluir vendedor\n" +
                "4. Atualizar vendedor\n" +
                "5. Comissão\n" +
                "6. Salário\n" +
                "7. Finalizar\n");
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
                // metodo comissão
                break;
            case 6:
                // metodo salario
                break;
            case 7:
                break;
        }
    }
}
