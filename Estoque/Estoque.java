package Estoque;
import Automoveis.Automovel;
import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import Registros.RegistroVenda;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

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
        Carros carros;
        try {
            carros = (Carros) Serializador.ler("Carros");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //adicionar os carros individualmente a ao estoque
        //ler arquivo moto
        Motos motos;
        try {
            motos = (Motos) Serializador.ler("Motos");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //adicionar as motos individualmente a ao estoque
        //ler arquivo caminhao
        Caminhoes caminhoes;
        try {
            caminhoes = (Caminhoes) Serializador.ler("Caminhoes");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //adicionar os caminhaos individualmente a ao estoque
        this.estoquecaminhao.addAll(caminhoes.getCaminhoes());
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

    public static void menuEstoque(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Cliente******\n" +
                "1. Registrar Venda\n" +
                "2. Registrar Aluguel\n" +
                "3. Visualizar Estoque\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
