package Pessoas;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String cep;

    public Pessoa(String nome, String cpf, int idade, String telefone, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }
}
