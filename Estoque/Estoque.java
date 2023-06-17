package Estoque;
import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Pessoas.Cliente;
import Pessoas.Vendedor;
import Registros.Registro;
import Registros.RegistroVenda;
import Registros.RegistroAluguel;

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

        RegistroVenda r = new RegistroVenda(carro,carro.getValor(),cliente,vendedor);
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
            System.out.println("Qual o chassi do caminhão que deseja vender? ");
            String chassi = teclado.nextLine();
            caminhao = caminhoes.findCaminhao(chassi.toUpperCase());
            if(caminhao==null){
                System.out.println("Não foi possivel encontrar um caminhão com esse chassi");
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
            System.out.println("Qual o CPF do Vendedor que vendeu o caminhão ?");
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
            System.out.println("Qual o CPF do Cliente que comprou o caminhão ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        RegistroVenda r = new RegistroVenda(caminhao,caminhao.getValor(),cliente,vendedor);
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
            System.out.println("Qual o chassi da moto que deseja vender? ");
            String chassi = teclado.nextLine();
            moto = motos.findMoto(chassi.toUpperCase());
            if(moto==null){
                System.out.println("Não foi possivel encontrar uma moto com esse chassi");
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
            System.out.println("Qual o CPF do Vendedor que vendeu a moto ?");
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
            System.out.println("Qual o CPF do Cliente que comprou a moto ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        RegistroVenda r = new RegistroVenda(moto,moto.getValor(),cliente,vendedor);
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void alugarcarro(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi do carro que deseja alugar: ");
            String chassi = teclado.nextLine();
            carro = carros.findCarro(chassi.toUpperCase());
            if(carro==null){
                System.out.println("Não foi possivel encontrar um carro com esse chassi");
            }else {
                if(carro.isAlugado()){
                    //carro já está sendo alugado
                    System.out.println("Este carro já está sendo alugado, e não pode ser alugado novamente");
                } else {
                    carro.setAlugado(true);
                    try {
                        Serializador.gravar("Carros", carros);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    break;
                }

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
            System.out.println("Qual o CPF do Cliente que alugou o carro ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        int tempo;
        while (true) {
            try {
                System.out.println("Quantas horas o cliente vai ficar com o carro ?");
                tempo = Integer.parseInt(teclado.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Por favor, digite apenas números");
            } catch (Exception e){
                System.out.println("Ocorreu um erro, tente novamente");
            }
        }

        RegistroAluguel r = new RegistroAluguel(carro,cliente,tempo);
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void alugarcaminhao(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi do caminhão que deseja alugar: ");
            String chassi = teclado.nextLine();
            caminhao = caminhoes.findCaminhao(chassi.toUpperCase());
            if(caminhao==null){
                System.out.println("Não foi possivel encontrar um caminhão com esse chassi");
            }else {
                if(caminhao.isAlugado()){
                    //carro já está sendo alugado
                    System.out.println("Este caminhão já está sendo alugado, e não pode ser alugado novamente");
                } else {
                    caminhao.setAlugado(true);
                    try {
                        Serializador.gravar("Caminhoes", caminhoes);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    break;
                }

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
            System.out.println("Qual o CPF do Cliente que alugou o caminhão ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        int tempo;
        while (true) {
            try {
                System.out.println("Quantas horas o cliente vai ficar com o caminhão ?");
                tempo = Integer.parseInt(teclado.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Por favor, digite apenas números");
            } catch (Exception e){
                System.out.println("Ocorreu um erro, tente novamente");
            }
        }

        RegistroAluguel r = new RegistroAluguel(caminhao,cliente,tempo);
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void alugarmoto(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi da moto que deseja alugar: ");
            String chassi = teclado.nextLine();
            moto = motos.findMoto(chassi.toUpperCase());
            if(moto==null){
                System.out.println("Não foi possivel encontrar uma moto com esse chassi");
            }else {
                if(moto.isAlugado()){
                    //carro já está sendo alugado
                    System.out.println("Esta moto já está sendo alugado, e não pode ser alugado novamente");
                } else {
                    moto.setAlugado(true);
                    try {
                        Serializador.gravar("Motos", motos);
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    break;
                }
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
            System.out.println("Qual o CPF do Cliente que alugou a moto ?");
            String cpf = teclado.nextLine();
            cpf = cpfformat(cpf);

            cliente = clientes.findcliente(cpf);
            if (cliente == null) {
                System.out.println("Não foi possivel encontrar nenhum cliente com este cpf");
            } else {
                break;
            }
        }

        int tempo;
        while (true) {
            try {
                System.out.println("Quantas horas o cliente vai ficar com a moto ?");
                tempo = Integer.parseInt(teclado.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Por favor, digite apenas números");
            } catch (Exception e){
                System.out.println("Ocorreu um erro, tente novamente");
            }
        }

        RegistroAluguel r = new RegistroAluguel(moto,cliente,tempo);
        registros.addRegistro(r);

        try {
            Serializador.gravar("Registro",registros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void finalizaraluguelcarro(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi do carro que deseja finalizar o aluguel? ");
            String chassi = teclado.nextLine();
            carro = carros.findCarro(chassi.toUpperCase());
            if(carro==null){
                System.out.println("Não foi possivel encontrar um carro com esse chassi");
            }else {
                break;
            }
        }
        Registro r = registros.findaluguel(carro);
        if (r == null){
            System.out.println("Este carro não está atualmente alugado");
        } else {
            carro.setAlugado(false);
            try {
                Serializador.gravar("Carros", carros);
            }catch (IOException e){
                throw new RuntimeException(e);
            }

            registros.removeRegistro(r);
            try {
                Serializador.gravar("Registro",registros);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Aluguel Finalizado com sucesso");
        }
    }

    public static void finalizaraluguelmoto(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi da moto que deseja finalizar o aluguel? ");
            String chassi = teclado.nextLine();
            moto = motos.findMoto(chassi.toUpperCase());
            if(moto==null){
                System.out.println("Não foi possivel encontrar uma moto com esse chassi");
            }else {
                break;
            }
        }
        Registro r = registros.findaluguel(moto);
        if (r == null){
            System.out.println("Esta moto não está atualmente alugada");
        } else {
            moto.setAlugado(false);
            try {
                Serializador.gravar("Motos", motos);
            }catch (IOException e){
                throw new RuntimeException(e);
            }

            registros.removeRegistro(r);
            try {
                Serializador.gravar("Registro",registros);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Aluguel Finalizado com sucesso");
        }
    }
    public static void finalizaraluguelcaminhao(Scanner teclado, Estoque estoque){
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
            System.out.println("Qual o chassi do caminhão que deseja finalizar o aluguel? ");
            String chassi = teclado.nextLine();
            caminhao = caminhoes.findCaminhao(chassi.toUpperCase());
            if(caminhao==null){
                System.out.println("Não foi possivel encontrar um caminhão com esse chassi");
            }else {
                break;
            }
        }
        Registro r = registros.findaluguel(caminhao);
        if (r == null){
            System.out.println("Este caminhão não está atualmente alugado");
        } else {
            caminhao.setAlugado(false);
            try {
                Serializador.gravar("Caminhoes", caminhoes);
            }catch (IOException e){
                throw new RuntimeException(e);
            }

            registros.removeRegistro(r);
            try {
                Serializador.gravar("Registro",registros);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Aluguel Finalizado com sucesso");
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
                //Ver Registro Venda;
                Registros registros;
                try {
                    registros  = (Registros) Serializador.ler("Registro");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                registros.viewRegistroVenda();
                break;
            case 3:
                //registrar alugel
                System.out.println(
                        "1. Carro\n" +
                        "2. Caminhão\n" +
                        "3. Moto\n");
                valido = false;
                int opalugel = 0;
                while (!valido) {
                    try {
                        System.out.print("Qual o tipo de veiculo que vocês alugou ? ");
                        teclado.nextLine();
                        opalugel = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas o número da opção desejada");
                    }
                }

                switch (opalugel){
                    case 1:
                        //alugar carro
                        Estoque alugacarro = new Estoque();
                        alugarcarro(teclado, alugacarro);
                        break;
                    case 2:
                        //alugar caminhao
                        Estoque alugacaminhao = new Estoque();
                        alugarcaminhao(teclado, alugacaminhao);
                        break;
                    case 3:
                        //alugar moto
                        Estoque alugamoto = new Estoque();
                        alugarmoto(teclado, alugamoto);
                        break;
                }
                break;
            case 4:
                //Finalizar aluguel
                System.out.println(
                        "1. Carro\n" +
                        "2. Caminhão\n" +
                        "3. Moto\n");
                valido = false;
                int opfinal = 0;
                while (!valido) {
                    try {
                        System.out.print("Qual o tipo de veiculo que vocês deseja finalizar um aluguel ? ");
                        teclado.nextLine();
                        opfinal = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor responda apenas o número da opção desejada");
                    }
                }

                switch (opfinal) {
                    case 1:
                        //alugar carro
                        Estoque fimcarro = new Estoque();
                        finalizaraluguelcarro(teclado,fimcarro);
                        break;
                    case 2:
                        //alugar caminhao
                        Estoque fimcaminhao = new Estoque();
                        finalizaraluguelcaminhao(teclado,fimcaminhao);
                        break;
                    case 3:
                        //alugar moto
                        Estoque fimmoto = new Estoque();
                        finalizaraluguelmoto(teclado,fimmoto);
                        break;
                }
                break;
            case 5:
                // Ver registros Aluguel
                try {
                    registros  = (Registros) Serializador.ler("Registro");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                registros.viewRegistroAluguel();
                break;
            case 6:
                // Ver o estoque
                Estoque estoque = new Estoque();
                estoque.viewEstoque();
                break;
            case 7:
                // Sair
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
