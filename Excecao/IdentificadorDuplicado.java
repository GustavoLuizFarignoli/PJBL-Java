package Excecao;

public class IdentificadorDuplicado extends Exception{

    public IdentificadorDuplicado() {
        super("Este atributo já está cadastro e não pode ser cadastrado novamente");
    }
}
