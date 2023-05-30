package Pessoas;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String cep;

    public Pessoa(int id, String nome, String cpf, int idade, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.cep = cep;
    }
}
