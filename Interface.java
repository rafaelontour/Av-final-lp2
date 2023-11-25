package src.mercado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame implements ActionListener {

    int e;

    Font fonte = new Font("Fonte",Font.ITALIC|Font.BOLD,20);
    Font fonte2 = new Font("Fonte",Font.ITALIC|Font.BOLD,40);





    private JPanel pnCabecalho;
    private JPanel pnRodape;
    private JPanel pnEsquerda;
    private JPanel pnDireita;
    private JPanel pnCentro;
    private JPanel pnCorpo;



    public Interface(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MENU");

        setLayout(new BorderLayout());
        iniciarComponentes();
        pack();
        setVisible(true);



    }


    public void adicionar(){
        setVisible(true);
        setLayout(null);

    }
    public void iniciarComponentes(){
        this.pnCabecalho = new JPanel();
        this.pnRodape = new JPanel();
        this.pnEsquerda = new JPanel();
        this.pnDireita = new JPanel();
        this.pnCentro = new JPanel();
        this.pnCorpo = new JPanel();

        iniciarCabecalho();
        iniciarCentro();

    }
    public void iniciarCabecalho(){
        this.pnCabecalho.setBackground(Color.gray);
        this.pnRodape.setBackground(Color.gray);
        this.pnEsquerda.setBackground(Color.gray);
        this.pnDireita.setBackground(Color.gray);
        this.pnCentro.setBackground(Color.darkGray);
        this.pnCorpo.setBackground(Color.darkGray);

        this.add(pnCabecalho, BorderLayout.PAGE_START);
        this.add(pnRodape, BorderLayout.PAGE_END);
        this.add(pnEsquerda, BorderLayout.LINE_START);
        this.add(pnDireita, BorderLayout.LINE_END);
        this.add(pnCorpo, BorderLayout.CENTER);

        this.pnCabecalho.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel texto = new JLabel("Escolha uma opção");
        texto.setFont(fonte2);
        texto.setForeground(Color.white);
        pnCorpo.add(texto);


    }
    public void iniciarCentro(){


        JButton botao1 = new JButton("Adicionar produto");
        JButton botao2 = new JButton("Consultar produto");
        JButton botao3 = new JButton("Alterar dados de um produto");
        JButton botao4 = new JButton("Excluir produto");
        JButton botao5 = new JButton("Listar produtos");
        JButton botao6 = new JButton("Consultar estoque");
        JButton botao7 = new JButton("Vender um produto");


        this.pnCabecalho.add(botao1);
        this.pnCabecalho.add(botao2);
        this.pnCabecalho.add(botao3);
        this.pnCabecalho.add(botao4);
        this.pnCabecalho.add(botao5);
        this.pnCabecalho.add(botao6);
        this.pnCabecalho.add(botao7);

        botao1.addActionListener(this::actionPerformed);
        botao2.addActionListener(this::actionPerformed2);
        botao3.addActionListener(this::actionPerformed3);
        }




    @Override
    public void actionPerformed(ActionEvent a) {

        this.pnCorpo.removeAll();
        this.pnRodape.removeAll();
        pnCorpo.setLayout(new GridLayout(1,3));
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
        JLabel texto = new JLabel("   Selecione o tipo de produto: ");
        texto.setForeground(Color.white);
        texto.setFont(fonte);

        pnCorpo.add(texto);



        JButton eletronico = new JButton("Eletrônicos");
        JButton alimento = new JButton("Alimentos");
        JButton utilidade = new JButton("Utilidades");

        pnCorpo.add(eletronico);
        pnCorpo.add(alimento);
        pnCorpo.add(utilidade);

        eletronico.addActionListener(this::acaoEletronico);
        alimento.addActionListener(this::acaoAlimento);
        utilidade.addActionListener(this::acaoUtilidade);





    }

    public void actionPerformed3(ActionEvent a) {
         e = 3 ;
        JOptionPane.showMessageDialog(null, e );//teste


    }
    public void acaoEletronico(ActionEvent a) {
        this.pnCorpo.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
        pnCorpo.setLayout(new GridLayout(3,2));

        JTextField entrada1 = new JTextField();
        entrada1.setFont(fonte);
        JTextField entrada2 = new JTextField();
        entrada2.setFont(fonte);
        JTextField entrada3 = new JTextField();
        entrada3.setFont(fonte);
        entrada1.setMargin(new Insets(0,10,0,0));
        entrada2.setMargin(new Insets(0,10,0,0));
        entrada3.setMargin(new Insets(0,10,0,0));

        JButton confirma = new JButton("Confirmar");

        JLabel texto1 = new JLabel("    Digite o nome do produto: ");
        texto1.setFont(fonte);
        JLabel texto2 = new JLabel("    Digite o preço do produto: ");
        texto2.setFont(fonte);
        JLabel texto3 = new JLabel("    Digite a quantidade adicionada do produto: ");
        texto3.setFont(fonte);
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        texto3.setForeground(Color.white);


        this.pnCorpo.add(texto1);
        this.pnCorpo.add(entrada1);
        this.pnCorpo.add(texto2);
        this.pnCorpo.add(entrada2);
        this.pnCorpo.add(texto3);
        this.pnCorpo.add(entrada3);
        this.pnRodape.add(confirma);
        confirma.addActionListener(this::reinicio);

    }
    public void acaoAlimento(ActionEvent a) {
        this.pnCorpo.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
        pnCorpo.setLayout(new GridLayout(3,2));

        JTextField entrada1 = new JTextField();
        entrada1.setFont(fonte);
        JTextField entrada2 = new JTextField();
        entrada2.setFont(fonte);
        JTextField entrada3 = new JTextField();
        entrada3.setFont(fonte);
        entrada1.setMargin(new Insets(0,10,0,0));
        entrada2.setMargin(new Insets(0,10,0,0));
        entrada3.setMargin(new Insets(0,10,0,0));

        JButton confirma = new JButton("Confirmar");

        JLabel texto1 = new JLabel("    Digite o nome do produto: ");
        texto1.setFont(fonte);
        JLabel texto2 = new JLabel("    Digite o preço do produto: ");
        texto2.setFont(fonte);
        JLabel texto3 = new JLabel("    Digite a quantidade adicionada do produto: ");
        texto3.setFont(fonte);
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        texto3.setForeground(Color.white);


        this.pnCorpo.add(texto1);
        this.pnCorpo.add(entrada1);
        this.pnCorpo.add(texto2);
        this.pnCorpo.add(entrada2);
        this.pnCorpo.add(texto3);
        this.pnCorpo.add(entrada3);
        this.pnRodape.add(confirma);
        confirma.addActionListener(this::reinicio);

    }
    public void acaoUtilidade(ActionEvent a) {
        this.pnCorpo.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
        pnCorpo.setLayout(new GridLayout(3,2));

        JTextField entrada1 = new JTextField();
        entrada1.setFont(fonte);
        JTextField entrada2 = new JTextField();
        entrada2.setFont(fonte);
        JTextField entrada3 = new JTextField();
        entrada3.setFont(fonte);
        entrada1.setMargin(new Insets(0,10,0,0));
        entrada2.setMargin(new Insets(0,10,0,0));
        entrada3.setMargin(new Insets(0,10,0,0));

        JButton confirma = new JButton("Confirmar");

        JLabel texto1 = new JLabel("    Digite o nome do produto: ");
        texto1.setFont(fonte);
        JLabel texto2 = new JLabel("    Digite o preço do produto: ");
        texto2.setFont(fonte);
        JLabel texto3 = new JLabel("    Digite a quantidade adicionada do produto: ");
        texto3.setFont(fonte);
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        texto3.setForeground(Color.white);


        this.pnCorpo.add(texto1);
        this.pnCorpo.add(entrada1);
        this.pnCorpo.add(texto2);
        this.pnCorpo.add(entrada2);
        this.pnCorpo.add(texto3);
        this.pnCorpo.add(entrada3);
        this.pnRodape.add(confirma);
        confirma.addActionListener(this::reinicio);

    }


    // acima tudo é relacionado ao botao adicionar ^

    public void reinicio(ActionEvent a) {
        this.pnCorpo.removeAll();
        this.pnRodape.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
        this.pnCorpo.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel texto = new JLabel("Escolha novamente uma opção");
        texto.setFont(fonte2);
        texto.setForeground(Color.white);
        pnCorpo.add(texto);

    }
    public void actionPerformed2(ActionEvent a) {
        e = 2;

        this.pnCorpo.removeAll();
        this.pnRodape.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();

        JLabel texto = new JLabel("  Qual produto deseja consultar? ");
        texto.setForeground(Color.WHITE);
        texto.setFont(fonte);
        pnCorpo.add(texto);

        JTextField entrada = new JTextField();
        pnCorpo.setLayout(new GridLayout(1,2));
        pnCorpo.add(entrada);
        entrada.setMargin(new Insets(0,10,0,0));

        JButton confirma = new JButton("Confirma");
        pnRodape.add(confirma);
        confirma.addActionListener(this::consultaConfirma);

    }
    public void consultaConfirma(ActionEvent a){
        this.pnCorpo.removeAll();
        this.pnRodape.removeAll();
        this.pnCorpo.revalidate();
        this.pnCorpo.repaint();
    }

}

