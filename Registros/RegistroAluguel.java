package Registros;
import Automoveis.Automovel;
import Pessoas.Cliente;
import Pessoas.Vendedor;
public class RegistroAluguel extends Registro {
    private int tempo;

    public RegistroAluguel(Automovel automovel, Cliente cliente, int tempo) {
        super(automovel,cliente);
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Automovel: " + getAutomovel().getModelo() +
                "\nTempo: " + this.tempo + "h" +
                "\nLocatário: " + getCliente().getNome();
    }
}

