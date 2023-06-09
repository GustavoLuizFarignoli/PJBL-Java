package Pessoas;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public static boolean validarCPF(String cpf) {
        // Removendo caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificando se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificando se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calculando o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int digito1 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verificando o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != digito1) {
            return false;
        }

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        int digito2 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verificando o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != digito2) {
            return false;
        }
        return true;
    }

    public static String cpfformat(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return cpf;
        }

        cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);

        return  cpf;
    }

    public static boolean validarCEP(String cep) {
        // Removendo caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        if (cep.length() != 8) {
            return false;
        }

        return true;
    }

    public static String formatcep(String cep){
        // Removendo caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        if (cep.length() != 8) {
            return cep; // Retorna o CEP sem formatação caso não tenha 8 dígitos
        }

        // Formatando o CEP no formato XXXXX-XXX
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }

    public static String formatcell(String telefone){
        if (telefone.length() == 8){
            return telefone.substring(0,4) + "-" + telefone.substring(4);
        }
        else if (telefone.length() == 9){
            return telefone.substring(0,5) + "-" + telefone.substring(5);
        } else {
            return telefone;
        }
    }
}
