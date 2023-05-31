package Formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class FormRefactored extends JFrame {

    private static final int TAMANHO_TXT = 10;

    protected JPanel pnlCarro;
    protected JPanel pnlMoto;
    protected JPanel pnlRodape;
    protected JTabbedPane jtabs;

    protected JButton btnEnviar;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    //Marca
    protected JLabel lblMarca;
    protected JTextField txtMarca;
    //Modelo
    protected JLabel lblModelo;
    protected JTextField txtModelo;
    //Ano
    protected JLabel lblAno;
    protected JTextField txtAno;
    //Tipo
    protected JLabel lblTipo;
    protected JTextField txtTipo;
    //Quilometragem
    protected JLabel lblKilomt;
    protected JTextField txtKilomt;
    //Combustível
    protected JLabel lblCombustivel;
    protected JTextField txtCombustivel;
    //Quantidade de marchas
    protected JLabel lblMarcha;
    protected JTextField txtMarcha;
    //Cor
    protected JLabel lblCor;
    protected JTextField txtCor;
    //Chassi
    protected JLabel lblChassi;
    protected JTextField txtChassi;
    //Tanque
    protected JLabel lblTanque;
    protected JTextField txtTanque;
    //Valor
    protected JLabel lblValor;
    protected JTextField txtValor;
    //Portas
    protected JLabel lblPorta;
    protected JTextField txtPorta;
    //Cavalagens
    protected JLabel lblHorsePw;
    protected JTextField txtHorsePw;
    //Cilindradas
    protected JLabel lblCilindradas;
    protected JTextField txtCilindradas;

    public FormRefactored() throws HeadlessException {
        this.inicializar();
    }

    private void inicializar() {
        this.setTitle("Cadastrar Carro");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);

        JPanel forcarro = new JPanel();
        forcarro.add(getPnlFormCarro(),BorderLayout.PAGE_START);
        forcarro.add(getPnlRodape(),BorderLayout.PAGE_END);

        JPanel formoto = new JPanel();
        formoto.add(getPnlMoto(),BorderLayout.PAGE_START);
        //formoto.add(getPnlRodape(),BorderLayout.PAGE_END);


        jtabs = new JTabbedPane();
        jtabs.add("Cadastrar Carro",forcarro);
        jtabs.add("Cadastrar Moto",formoto);

        this.getContentPane().add(jtabs,BorderLayout.CENTER);
        //this.getContentPane().add(getPnlMoto(), BorderLayout.CENTER);
        //this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.pack();
    }
    public JPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnEnviar = new JButton("Enviar");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnEnviar);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }

    public JPanel getPnlFormCarro() {
        if (pnlCarro == null) {
            pnlCarro = new JPanel(new GridLayout(13, 2, 5, 1));
            pnlCarro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            lblMarca = new JLabel("Marca:");
            txtMarca = new JTextField(TAMANHO_TXT);

            lblModelo = new JLabel("Modelo:");
            txtModelo = new JTextField(TAMANHO_TXT);

            lblAno = new JLabel("Ano do carro:");
            txtAno = new JTextField(TAMANHO_TXT);

            lblTipo = new JLabel("Tipo:");
            txtTipo = new JTextField(TAMANHO_TXT);

            lblKilomt = new JLabel("Quilometragem:");
            txtKilomt = new JTextField(TAMANHO_TXT);

            lblCombustivel = new JLabel("Combustível:");
            txtCombustivel = new JTextField(TAMANHO_TXT);

            lblMarcha = new JLabel("Quantidade de marchas:");
            txtMarcha = new JTextField(TAMANHO_TXT);

            lblCor = new JLabel("Cor:");
            txtCor = new JTextField(TAMANHO_TXT);

            lblChassi = new JLabel("Chassi:");
            txtChassi = new JTextField(TAMANHO_TXT);

            lblTanque = new JLabel("Capacidade do tanque:");
            txtTanque = new JTextField(TAMANHO_TXT);

            lblValor = new JLabel("Valor:");
            txtValor = new JTextField(TAMANHO_TXT);

            lblPorta = new JLabel("Quantidade de portas");
            txtPorta = new JTextField(TAMANHO_TXT);

            lblHorsePw = new JLabel("Quantidade de cavalos");
            txtHorsePw = new JTextField(TAMANHO_TXT);

            pnlCarro.add(lblMarca);
            pnlCarro.add(txtMarca);

            pnlCarro.add(lblModelo);
            pnlCarro.add(txtModelo);

            pnlCarro.add(lblAno);
            pnlCarro.add(txtAno);

            pnlCarro.add(lblTipo);
            pnlCarro.add(txtTipo);

            pnlCarro.add(lblKilomt);
            pnlCarro.add(txtKilomt);

            pnlCarro.add(lblCombustivel);
            pnlCarro.add(txtCombustivel);

            pnlCarro.add(lblMarcha);
            pnlCarro.add(txtMarcha);

            pnlCarro.add(lblCor);
            pnlCarro.add(txtCor);

            pnlCarro.add(lblChassi);
            pnlCarro.add(txtChassi);

            pnlCarro.add(lblTanque);
            pnlCarro.add(txtTanque);

            pnlCarro.add(lblValor);
            pnlCarro.add(txtValor);

            pnlCarro.add(lblPorta);
            pnlCarro.add(txtPorta);

            pnlCarro.add(lblHorsePw);
            pnlCarro.add(txtHorsePw);

            pnlCarro.add(lblTipo);
            pnlCarro.add(txtTipo);
        }
        return pnlCarro;

    }

    public JPanel getPnlMoto() {
        if (pnlMoto == null) {
            pnlMoto = new JPanel(new GridLayout(13, 2, 5, 1));
            pnlMoto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            lblMarca = new JLabel("Marca:");
            txtMarca = new JTextField(TAMANHO_TXT);

            lblModelo = new JLabel("Modelo:");
            txtModelo = new JTextField(TAMANHO_TXT);

            lblAno = new JLabel("Ano do carro:");
            txtAno = new JTextField(TAMANHO_TXT);

            lblTipo = new JLabel("Tipo:");
            txtTipo = new JTextField(TAMANHO_TXT);

            lblKilomt = new JLabel("Quilometragem:");
            txtKilomt = new JTextField(TAMANHO_TXT);

            lblCombustivel = new JLabel("Combustível:");
            txtCombustivel = new JTextField(TAMANHO_TXT);

            lblMarcha = new JLabel("Quantidade de marchas:");
            txtMarcha = new JTextField(TAMANHO_TXT);

            lblCor = new JLabel("Cor:");
            txtCor = new JTextField(TAMANHO_TXT);

            lblChassi = new JLabel("Chassi:");
            txtChassi = new JTextField(TAMANHO_TXT);

            lblTanque = new JLabel("Capacidade do tanque:");
            txtTanque = new JTextField(TAMANHO_TXT);

            lblValor = new JLabel("Valor:");
            txtValor = new JTextField(TAMANHO_TXT);

            lblCilindradas = new JLabel("Cilindradas");
            txtCilindradas= new JTextField(TAMANHO_TXT);

            pnlMoto.add(lblMarca);
            pnlMoto.add(txtMarca);

            pnlMoto.add(lblModelo);
            pnlMoto.add(txtModelo);

            pnlMoto.add(lblAno);
            pnlMoto.add(txtAno);

            pnlMoto.add(lblTipo);
            pnlMoto.add(txtTipo);

            pnlMoto.add(lblKilomt);
            pnlMoto.add(txtKilomt);

            pnlMoto.add(lblCombustivel);
            pnlMoto.add(txtCombustivel);

            pnlMoto.add(lblMarcha);
            pnlMoto.add(txtMarcha);

            pnlMoto.add(lblCor);
            pnlMoto.add(txtCor);

            pnlMoto.add(lblChassi);
            pnlMoto.add(txtChassi);

            pnlMoto.add(lblTanque);
            pnlMoto.add(txtTanque);

            pnlMoto.add(lblValor);
            pnlMoto.add(txtValor);

            pnlMoto.add(lblCilindradas);
            pnlMoto.add(txtCilindradas);
        }
        return pnlMoto;

    }
}
