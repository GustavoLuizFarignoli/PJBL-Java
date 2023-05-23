import java.util.Map;

public class Estoque {
    private Map<Automovel,Integer> estoque;

    public Estoque(Map<Automovel, Integer> estoque) {
        this.estoque = estoque;
    }

    public void addEstoque(Automovel automovel, int quantidade) {
        this.estoque.put(automovel,quantidade);
    }
    public void removeEstoque(Automovel automovel, int quantidade) {
        int valor = this.estoque.get(automovel);
        valor += 1;
        this.estoque.put(automovel,valor);

    }
}
