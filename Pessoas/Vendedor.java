package Pessoas;
import Estoque.Funcionario;
import Estoque.Serializador;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vendedor extends Pessoa implements Serializable {
    private int salario;
    private double comissao;
    private int qtvendas;

    public Vendedor(String nome, String cpf, int idade, String telefone, String cep, int salario, double comissao, int qtvendas) {
        super(nome, cpf, idade, telefone, cep);
        this.salario = salario;
        this.comissao = comissao;
        this.qtvendas = qtvendas;
    }

    public double getComissao() {
        return comissao;
    }

    public int getSalario() {
        return salario;
    }

    public int getQtvendas() {
        return qtvendas;
    }
    public void setComissao(double valor) {
        if (valor >= 100000){
            this.comissao += (valor * 0.03);
        }else if (valor >= 50000){
            this.comissao += (valor * 0.08);
        }else{
            this.comissao += (valor * 0.13);
        }
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setQtvendas(int qtvendas) {
        this.qtvendas = qtvendas;
    }

    public void Pagamento(){
        double pagamento = this.salario + this.comissao;
        System.out.println("O Funcionário " + getNome() + ", Deve receber um total de " + pagamento );
        this.comissao = 0;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()+
                "\nCPF: " + getCpf() +
                "\nCEP: " + getCep() +
                "\nIdade: " + getIdade() +
                "\nTelefone: +55 (41) " + getTelefone() +
                "\nSalário: " + getSalario() +
                "\nComissão: " + getComissao() +
                "\nQuantidade de vendas: " + getQtvendas();
    }
    public static void menuVendedor(int op){
        Scanner teclado = new Scanner(System.in);
        System.out.println("******Menu Vendedor******\n" +
                "1. Casdastrar vendedor\n" +
                "2. Editar vendedor\n" +
                "3. Demitir vendedor\n" +
                "4. Visualizar vendedor\n" +
                "5. Ver todos os vendedores\n" +
                "6. Comissão\n" +
                "7. Folha de Pagamento\n" +
                "8. Finalizar\n");
        System.out.print("Digite o comando desejado: ");
        op = teclado.nextInt();
        switch (op) {
            case 1:
                teclado.nextLine(); //Preciso dessa linha, pois o nextint não "consome" o /n
                boolean valido = false;

                String nome = "";
                while (nome.length() == 0){
                    System.out.println("Digite o Nome deste Vendedor: ");
                    nome = teclado.nextLine();
                }
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

                String cpf = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o CPF deste Vendedor: ");
                        cpf = teclado.nextLine();
                        if (validarCPF(cpf)) { // Transformar em Exception ?
                            valido = true;
                            cpf = cpfformat(cpf);
                        } else {
                            System.out.println("Número de CPF Inválido");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro de formato");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int idade = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite a idade deste Vendedor: ");
                        idade = Integer.parseInt(teclado.nextLine());
                        if (idade < 18){
                            valido = true;
                        }else {
                            System.out.println("Os funcionários precisam ser maior de idade");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }


                valido = false;
                String numtelefone = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o Telefone deste Vendedor sem DDD: ");
                        numtelefone = teclado.nextLine();
                        if (numtelefone.length() < 8 || numtelefone.length() > 9) { // Transformar em Exception ?
                            System.out.println("Número de Telefone Inválido, Ele deve conter entre 8 a 9 digitos");
                        } else {
                            valido = true;
                            numtelefone = formatcell(numtelefone);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                String cep = "";
                while (!valido) {
                    try {
                        System.out.println("Digite o CEP deste Vendedor: ");
                        cep = teclado.nextLine();
                        if (validarCEP(cep)) {
                            valido = true;
                            cep = formatcep(cep);
                        } else {
                            System.out.println("Número de CEP Inválido");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                valido = false;
                int salario = 0;
                while (!valido) {
                    try {
                        System.out.println("Digite o salario deste Vendedor: ");
                        salario = Integer.parseInt(teclado.nextLine());
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor responda apenas com números inteiros");
                    } catch (Exception e) {
                        System.out.println("Erro Desconhecido, tente novamente");
                    }
                }

                Funcionario cadastro;
                try {
                    cadastro = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                Vendedor v = new Vendedor(nome,cpf, idade,numtelefone,cep,salario,0,0);

                cadastro.addFuncionario(v);
                try {
                    Serializador.gravar("Funcionarios",cadastro);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                // Metodo editar
                Funcionario editar;
                try {
                    editar = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Cliente que deseja editar ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Vendedor edit = editar.findcliente(cpf);
                if (edit == null){
                    System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
                } else {
                    //Código editar
                    System.out.println(edit);
                    System.out.println("===========================");

                    System.out.println("Digite o novo nome (ou deixe em branco para manter o valor atual):");
                    nome = teclado.nextLine();
                    if(!nome.isEmpty()){
                        edit.setNome(nome);
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a nova idade (ou digite 0 para manter o valor atual):");
                            idade = Integer.parseInt(teclado.nextLine());
                            if(idade == 0){
                              valido = true;
                            }else if(idade >= 18){
                                edit.setIdade(idade);
                                valido = true;
                            } else {
                                System.out.println("Idade inválida");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o novo Telefone deste Cliente sem DDD (ou deixe em branco para manter o valor atual): ");
                            numtelefone = teclado.nextLine();
                            if (numtelefone.length() < 8 || numtelefone.length() > 9) { // Transformar em Exception ?
                                if (numtelefone.isEmpty()){
                                    valido = true;
                                } else {
                                    System.out.println("Número de Telefone Inválido, Ele deve conter entre 8 a 9 digitos");
                                }
                            } else {
                                valido = true;
                                numtelefone = formatcell(numtelefone);
                                edit.setTelefone(numtelefone);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o novo CEP deste Cliente (ou deixe em branco para manter o valor atual):  ");
                            cep = teclado.nextLine();
                            if (validarCEP(cep)) {
                                valido = true;
                                edit.setCep(formatcep(cep));
                            } else if (cep.isEmpty()) {
                                valido = true;
                            } else {
                                System.out.println("Número de CEP Inválido");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }
                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite a novo salário (ou digite 0 para manter o valor atual):");
                            salario = Integer.parseInt(teclado.nextLine());
                            valido = true;
                            if(salario != 0){
                                edit.setSalario(salario);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor responda apenas com números inteiros");
                        } catch (Exception e) {
                            System.out.println("Erro Desconhecido, tente novamente");
                        }
                    }

                    try {
                        Serializador.gravar("Funcionarios",editar);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 3:
                // Metodo excluir
                Funcionario excluir;
                try {
                    excluir = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Vendedor que deseja excluir ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Vendedor ex = excluir.findcliente(cpf);
                if (ex == null){
                    System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
                } else {
                    excluir.removeFuncionario(ex);
                    try {
                        Serializador.gravar("Funcionarios",excluir);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Vendedor Excluido com sucesso");
                }
                break;
            case 4:
                // metodo atualizar
                Funcionario visualizar;
                try {
                    visualizar = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Vendedor que deseja visualizar ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Vendedor ver = visualizar.findcliente(cpf);
                if (ver == null){
                    System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
                } else {
                    System.out.println(ver);
                }
                break;
            case 5:
                // metodo visualizar todos
                Funcionario vertodos;
                try {
                    vertodos = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                vertodos.viewfuncionarios();
                break;
            case 6:
                // metodo comissão
                Funcionario editarcomissao;
                try {
                    editarcomissao = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                teclado.nextLine();
                System.out.println("Qual o CPF do Cliente que deseja editar ?");
                cpf = teclado.nextLine();
                cpf = cpfformat(cpf);

                Vendedor editcomissao = editarcomissao.findcliente(cpf);
                if (editcomissao == null){
                    System.out.println("Não foi possivel encontrar nenhum vendedor com este cpf");
                } else {
                    System.out.println(editcomissao);
                    System.out.println("===========================");


                    valido = false;
                    while (!valido) {
                        try {
                            System.out.println("Digite o valor da comissão: ");
                            double comissao = Double.parseDouble(teclado.nextLine());
                            editcomissao.setComissao(comissao);
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro, tente novamente");
                        }
                    }

                    try {
                        Serializador.gravar("Funcionarios",editarcomissao);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 7:
                // metodo salario
                Funcionario verpagamentos;
                try {
                    verpagamentos = (Funcionario) Serializador.ler("Funcionarios");
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                verpagamentos.viewpagamentos();

                try {
                    Serializador.gravar("Funcionarios",verpagamentos);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 8:
                break;
            case 9:
                // Opção de debug
                Funcionario cadastro1 = new Funcionario();

                Vendedor v1 = new Vendedor("Felipe","168.301.107-42",25,"9911-9911","85806-768",0,0,0);

                cadastro1.addFuncionario(v1);
                try {
                    Serializador.gravar("Funcionarios",cadastro1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
