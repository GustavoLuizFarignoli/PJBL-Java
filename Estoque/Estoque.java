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
import java.util.Scanner;

import static Pessoas.Pessoa.cpfformat;

public class Estoque implements Serializable {
    private ArrayList<Carro> estoquecarros = new ArrayList<>();
    private ArrayList<Moto> estoquemoto = new ArrayList<>();
    private ArrayList<Caminhao> estoquecaminhao = new ArrayList<>();


    public Estoque(){
        Carros carros;
        try {
            carros = (Carros) Serializador.ler("Carros");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //adicionar os carros individualmente a ao estoque
        this.estoquecarros.addAll(carros.getCarros());
        //ler arquivo moto
        Motos motos;
        try {
            motos = (Motos) Serializador.ler("Motos");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //adicionar as motos individualmente a ao estoque
        this.estoquemoto.addAll(motos.getlista());
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


    public void viewEstoque(){
        System.out.println("===========Carros===========");
        for (Carro c : this.estoquecarros){
            System.out.println(c);
            System.out.println("============================");

        }
        System.out.println("============Motos============");
        for (Moto m : this.estoquemoto){
            System.out.println(m);
            System.out.println("============================");

        }
        System.out.println("==========Caminhão==========");
        for (Caminhao ca : this.estoquecaminhao){
            System.out.println(ca);
            System.out.println("============================");

        }
    }

    public static void vendercarro(Scanner teclado,Estoque estoque){

        Registros registros;
        try {
            registros  = (Registros) Serializador.ler("Registro");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Carros carros = new Carros();
        carros.setCarros(estoque.estoquecarros);

        Carro carro;
        while (true){
            System.out.println("Qual o chassi do carro que deseja vender: ");
            String chassi = teclado.nextLine();
            carro = carros.findCarro(chassi.toUpperCase());
            if(carro==null){
                System.out.println("Não foi possivel encontrar um carro com esse chassi");
            }else {
                carros.removeCarro(carro);
                try {
                    Serializador.gravar("Carros", carros);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Funcionario funcionario;
        try {
            funcionario = (Funcionario) Serializador.ler("Funcionarios");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Vendedor vendedor;
        while (true){
            System.out.println("Qual o CPF do Vendedor que vendeu o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);
            vendedor = funcionario.findfuncionario(cpf);
            if (vendedor == null){
                System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
            } else {
                vendedor.setComissao(carro.getValor());
                try {
                    Serializador.gravar("Funcionarios",funcionario);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Clientes clientes;
        try {
            clientes = (Clientes) Serializador.ler("Clientes");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Cliente cliente;
        while (true) {
            teclado.nextLine();
            System.out.println("Qual o CPF do Cliente que comprou o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        RegistroVenda r = new RegistroVenda(carro,vendedor,cliente,carro.getValor());
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void vendercaminhao(Scanner teclado,Estoque estoque){

        Registros registros;
        try {
            registros  = (Registros) Serializador.ler("Registro");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Caminhoes caminhoes = new Caminhoes();
        caminhoes.setCaminhoes(estoque.estoquecaminhao);

        Caminhao caminhao;
        while (true){
            System.out.println("Qual o chassi do carro que deseja vender: ");
            String chassi = teclado.nextLine();
            caminhao = caminhoes.findCaminhao(chassi.toUpperCase());
            if(caminhao==null){
                System.out.println("Não foi possivel encontrar um carro com esse chassi");
            }else {
                caminhoes.removeCaminhao(caminhao);
                try {
                    Serializador.gravar("Caminhoes", caminhoes);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Funcionario funcionario;
        try {
            funcionario = (Funcionario) Serializador.ler("Funcionarios");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Vendedor vendedor;
        while (true){
            System.out.println("Qual o CPF do Vendedor que vendeu o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);
            vendedor = funcionario.findfuncionario(cpf);
            if (vendedor == null){
                System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
            } else {
                vendedor.setComissao(caminhao.getValor());
                try {
                    Serializador.gravar("Funcionarios",funcionario);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Clientes clientes;
        try {
            clientes = (Clientes) Serializador.ler("Clientes");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Cliente cliente;
        while (true) {
            teclado.nextLine();
            System.out.println("Qual o CPF do Cliente que comprou o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        RegistroVenda r = new RegistroVenda(caminhao,vendedor,cliente,caminhao.getValor());
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void vendermoto(Scanner teclado,Estoque estoque){

        Registros registros;
        try {
            registros  = (Registros) Serializador.ler("Registro");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Motos motos = new Motos();
        motos.setMotos(estoque.estoquemoto);

        Moto moto;
        while (true){
            System.out.println("Qual o chassi do carro que deseja vender: ");
            String chassi = teclado.nextLine();
            moto = motos.findMoto(chassi.toUpperCase());
            if(moto==null){
                System.out.println("Não foi possivel encontrar um carro com esse chassi");
            }else {
                motos.removeMoto(moto);
                try {
                    Serializador.gravar("Motos", motos);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Funcionario funcionario;
        try {
            funcionario = (Funcionario) Serializador.ler("Funcionarios");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Vendedor vendedor;
        while (true){
            System.out.println("Qual o CPF do Vendedor que vendeu o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);
            vendedor = funcionario.findfuncionario(cpf);
            if (vendedor == null){
                System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
            } else {
                vendedor.setComissao(moto.getValor());
                try {
                    Serializador.gravar("Funcionarios",funcionario);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Clientes clientes;
        try {
            clientes = (Clientes) Serializador.ler("Clientes");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Cliente cliente;
        while (true) {
            teclado.nextLine();
            System.out.println("Qual o CPF do Cliente que comprou o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        RegistroVenda r = new RegistroVenda(moto,vendedor,cliente,moto.getValor());
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void menuEstoque(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Cliente******\n" +
                "1. Registrar Venda\n" +
                "2. Visualizar Vendas\n" +
                "3. Registrar Aluguel\n" +
                "4. Finalizar Aluguel\n" +
                "5. Visualizar Alugueis\n" +
                "6. Visualizar Estoque\n" +
                "7. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                System.out.println(
                        "1. Carro\n" +
                        "2. Caminhão\n" +
                        "3. Moto\n");
                boolean valido = false;
                int opvenda = 0;
                while (!valido) {
                    try {
                        System.out.print("Qual o tipo de veiculo que vocês vendeu ? ");
                        teclado.nextLine();
                        opvenda = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas o número da opção desejada");
                    }
                }

                switch (opvenda){
                    case 1:
                        //vender carro
                        Estoque vendacarro = new Estoque();
                        vendercarro(teclado, vendacarro);
                        break;
                    case 2:
                        //vender caminhao
                        Estoque vendercaminhao = new Estoque();
                        vendercaminhao(teclado, vendercaminhao);
                        break;
                    case 3:
                        //vender moto
                        Estoque vendermoto = new Estoque();
                        vendermoto(teclado, vendermoto);
                        break;
                }

                break;
            case 2:
                Registros registros;
                try {
                    registros  = (Registros) Serializador.ler("Registro");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                registros.viewRegistro();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                Estoque estoque = new Estoque();
                estoque.viewEstoque();
                break;
            case 7:
                break;
            case 8:
                Registros registros1 = new Registros();
                try {
                    Serializador.gravar("Registro",registros1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
