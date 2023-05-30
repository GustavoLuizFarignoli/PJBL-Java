public class Vendedor extends Pessoa {
    private int salario;
    private double comissao;
    private int qtvendas;

    public Vendedor(int id, String nome, String cpf, int idade, String telefone, String cep, int salario, double comissao, int qtvendas) {
        super(id, nome, cpf, idade, telefone, cep);
        this.salario = salario;
        this.comissao = comissao;
        this.qtvendas = qtvendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}