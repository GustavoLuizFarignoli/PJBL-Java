package Estoque;
import Automoveis.Automovel;
import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import Registros.RegistroVenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Estoque implements Serializable {
    private ArrayList<Automovel> estoque = new ArrayList<>();
    private ArrayList<Carro> estoquecarros = new ArrayList<>();
    private ArrayList<Moto> estoquemoto = new ArrayList<>();
    private ArrayList<Caminhao> estoquecaminhao = new ArrayList<>();


    public Estoque(ArrayList <Automovel> estoque) {
        this.estoque = estoque;
    }

    public Estoque(){
        //ler arquivo carro
        //adicionar os carros individualmente a ao estoque
        //ler arquivo moto
        //adicionar as motos individualmente a ao estoque
        //ler arquivo caminhao
        //adicionar os caminhaos individualmente a ao estoque
    }

    public void setEstoques(){
        for (Automovel a : this.estoque){
            if (a instanceof Carro){
                Carro carro = (Carro) a;
                this.estoquecarros.add(carro);
            } else if (a instanceof Moto) {
                Moto moto = (Moto) a;
                this.estoquemoto.add(moto);
            } else if (a instanceof Caminhao) {
                Caminhao caminhao = (Caminhao) a;
                this.estoquecaminhao.add(caminhao);
            }
        }
    }

    public void viewEstoque(){
        setEstoques();
        System.out.println("===========Carros===========");
        for (Carro c : this.estoquecarros){
            System.out.println(c);
        }
        System.out.println("============Motos============");
        for (Moto m : this.estoquemoto){
            System.out.println(m);
        }
        System.out.println("==========Caminhão==========");
        for (Caminhao ca : this.estoquecaminhao){
            System.out.println(ca);
        }
        System.out.println("============================");
    }

    public void vender(Automovel a, Vendedor v, Cliente c, Date data){
        //ler estoque
        RegistroVenda r = new RegistroVenda(a,v,c,data,a.getValor());
        System.out.println(r);
        this.estoque.remove(a);
        v.setComissao(a.getValor());
        //gravar estoque
        //fora da função remover o automovel do arquivo correspondente e gravar
    }
}
