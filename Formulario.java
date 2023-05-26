import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {

    private JTextField campoMarca;
    private JTextField campoModelo;
    private JTextField campoAno;
    private JTextField campoTipo;
    private JTextField campoKilomt;
    private JTextField campoCombustivel;
    private JTextField campoQtmarcha;
    private JTextField campoCor;
    private JTextField campoChassi;
    private JTextField campoTanque;

    public Formulario() {
        // Configurações básicas da janela
        setTitle("Formulário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Cria rótulos
        JLabel labelMarca = new JLabel("Marca:");
        JLabel labelModelo = new JLabel("Modelo:");
        JLabel labelAno = new JLabel("Ano do veículo");
        JLabel labelTipo = new JLabel("Tipo(Automático/Manual):");
        JLabel labelKilomt = new JLabel("Quilometragem:");
        JLabel labelCombustivel = new JLabel("Tipo de combustivel:");
        JLabel labelQtmarcha = new JLabel("Quantidade de marcha:");
        JLabel labelCor = new JLabel("Cor do veículo:");
        JLabel labelChassi = new JLabel("Chassi:");
        JLabel labelTanque = new JLabel("Tamanho do tanque:");

        // Cria campos de texto
        campoMarca = new JTextField(20);
        campoModelo = new JTextField(20);
        campoAno = new JTextField(20);
        campoTipo = new JTextField(20);
        campoKilomt = new JTextField(20);
        campoCombustivel = new JTextField(20);
        campoQtmarcha = new JTextField(20);
        campoCor = new JTextField(20);
        campoChassi = new JTextField(20);
        campoTanque = new JTextField(20);

        // Cria botão de envio
        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirValores();
            }
        });

        // Adiciona os componentes à janela
        add(labelMarca);
        add(campoMarca);
        add(labelModelo);
        add(campoModelo);
        add(labelAno);
        add(campoAno);
        add(labelTipo);
        add(campoTipo);
        add(labelKilomt);
        add(campoKilomt);
        add(labelCombustivel);
        add(campoCombustivel);
        add(labelQtmarcha);
        add(campoQtmarcha);
        add(labelCor);
        add(campoCor);
        add(labelChassi);
        add(campoChassi);
        add(labelTanque);
        add(campoTanque);



        add(botaoEnviar);
    }

    private void exibirValores() {
        String Marca = campoMarca.getText();
        String Modelo = campoModelo.getText();
        String Ano = campoAno.getText();
        String Kilomt = campoKilomt.getText();
        String Tipo = campoTipo.getText();
        String Combustivel = campoCombustivel.getText();
        String QtMarcha = campoQtmarcha.getText();
        String Cor = campoCor.getText();
        String Chassi = campoChassi.getText();
        String Tanque = campoTanque.getText();
        System.out.println("Marca: " + Marca);
        System.out.println("Modelo: " + Modelo);
        System.out.println("Ano: " + Ano);
        System.out.println("Kilomt: " + Kilomt);
        System.out.println("Tipo: " + Tipo);
        System.out.println("Combustivel: " + Combustivel);
        System.out.println("Quantidade de marcha: " + QtMarcha);
        System.out.println("Cor: " + Cor);
        System.out.println("Chassi: " + Chassi);
        System.out.println("tamanho do tanque: " + Tanque);
    }

    public static void main(String[] args) {
        Formulario formulario = new Formulario();
        formulario.setVisible(true);
    }
}