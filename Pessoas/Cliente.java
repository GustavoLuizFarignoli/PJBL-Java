package Pessoas;

import Pessoas.Pessoa;

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
}
