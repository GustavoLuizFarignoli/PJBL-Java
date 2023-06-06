package Estoque;

import Automoveis.Automovel;

import java.io.IOException;
import java.util.Map;

public class Estoque extends Serializador {
    private Map<Automovel,Integer> estoque;

    public Estoque(Map<Automovel, Integer> estoque) {
        this.estoque = estoque;
    }

    public void addEstoque(Automovel automovel, int quantidade) {
        int valor = this.estoque.get(automovel); //Adicionar Classe para exceção do carro não estar no estoque ?
        valor += quantidade;
        this.estoque.put(automovel,valor);
        try {
            gravar("Estoque",this.estoque);
        } catch (IOException e) {
            throw new RuntimeException(e); // Fazer Tratamento correto deste Erro
        }
    }
    public void removeEstoque(Automovel automovel, int quantidade) {
        int valor = this.estoque.get(automovel);
        valor -= quantidade;
        if (valor <=0){ // adicionar isso como uma classe de exceção ?
            this.estoque.remove(automovel);
        } else {
            this.estoque.put(automovel,valor);
        }
        try {
            gravar("Estoque",this.estoque);
        } catch (IOException e) {
            throw new RuntimeException(e); // Fazer Tratamento correto deste Erro
        }
    }
    public void verestoque(){
        try {
            this.estoque = lerhash("Estoque");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry<Automovel, Integer> entry : this.estoque.entrySet()) {
            Automovel automovel = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println(automovel.toString() + ", Quantidade: " + quantidade); // Mudar método toString por método de imprimir
        }
    }


}
