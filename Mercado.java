package src.mercado;
import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Scanner;

public class Mercado implements InterfaceMercado {

    //Atributos 
    private String nome;
    private String endereco;
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    private Estoque estoque;

    // Construtor
    public Mercado(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.estoque = new Estoque();
    }

    // Getter
    ArrayList getListaDeProdutos() {
        return this.listaDeProdutos;
    }
    Estoque getEstoque() { return this.estoque; }

    // Outros métodos
    @Override
    public void adicionar(String nome, float preco, int qtd, int escolha) {
        switch (escolha) {
            case 1:
                ProdutoEletronico p = new ProdutoEletronico(nome, preco, qtd);
                this.listaDeProdutos.add(p);
                this.atualizarEstoque(p, 1);
                break;
            case 2:
                ProdutoAlimento p2 = new ProdutoAlimento(nome, preco, qtd);
                this.listaDeProdutos.add(p2);
                this.atualizarEstoque(p2, 1);
                break;
            case 3:
                ProdutoUtilidades p3 = new ProdutoUtilidades(nome, preco, qtd);
                this.listaDeProdutos.add(p3);
                this.atualizarEstoque(p3, 1);
                break;
        }
    }

    @Override
    public void consultar(String nomeP) {
        for (int i = 0;i < listaDeProdutos.size();i++) {
            if (listaDeProdutos.get(i).getNome().equals(nomeP)) {
                System.out.println("\nProduto: " + listaDeProdutos.get(i).getNome());
                System.out.println("Preço: R$" + listaDeProdutos.get(i).getPreco());
                System.out.println("Quantidade: " + listaDeProdutos.get(i).getQtd());
                System.out.println("Tipo: " + listaDeProdutos.get(i).getTipo() + "\n");
                break;
            }
        }
    }

    @Override
    public void alterar(String pa) {
        for (int c = 0;c < listaDeProdutos.size();c++) {
            if (listaDeProdutos.get(c).getNome().equals(pa)) {
                Scanner op = new Scanner(System.in);
                String nome;
                float preco;
                int qtd;

                System.out.print("Digite o nome do novo produto: ");
                nome = op.nextLine();
                listaDeProdutos.get(c).setNome(nome.toUpperCase());

                System.out.print("Digite o novo preço: R$" );
                preco = op.nextFloat();
                listaDeProdutos.get(c).setPreco(preco);

                System.out.print("Digite a quantidade nova: ");
                qtd = op.nextInt();
                listaDeProdutos.get(c).setQtd(qtd);

                break;
            }
        }
    }

    @Override
    public void excluir(String item) {
        int check = 0;
        for (int c = 0;c < listaDeProdutos.size();c++) {
            if (listaDeProdutos.get(c).getNome().equals(item)) {
                System.out.println("Produto '" + listaDeProdutos.get(c).getNome() + "' removido!");
                this.atualizarEstoque(this.listaDeProdutos.get(c), 2);

                listaDeProdutos.remove(c);

                check++;
                break;
            }
        }
        System.out.println("ANTES DE IMPRIMIR");
        this.imprimir();
        if (check == 0) {
            System.out.println("Produto não cadastrado!");
        }

    }

    @Override
    public void imprimir() {
        if (listaDeProdutos.size() != 0) {
            System.out.println("         Produtos cadastrados\n");
            for (int c = 0;c < listaDeProdutos.size();c++) {
                System.out.println((c + 1) + " - " + listaDeProdutos.get(c).getNome());
            }
        } else {
            System.out.println("Nenhum produto cadastrado.\n");
        }

    }

    boolean verificar() {
        if (this.listaDeProdutos.size() == 0) {
            return false;
        } else { return true; }
    }

    boolean verificarProduto(String pa) {
        boolean r = false;
        for (Produto p : this.listaDeProdutos) {
            if (p.getNome().equals(pa)) {
                r = true;
            } else {
                r = false;
            }
        }
        return r;
    }

    public void consultarEstoque() {
        System.out.println("         Estoque");
        System.out.println("***************************");
        System.out.println("\nQuantidade total de produtos: " + estoque.getTotProdutos());
        System.out.println("Qauntidade de produtos eletrônicos: " + estoque.getTotEletronicos());
        System.out.println("Quantidade de produtos alimentícios: " + estoque.getTotAlimentos());
        System.out.println("Quantidade de produtos utilitários: " + estoque.getTotUtilidades());
        System.out.println("Valor total do estoque: R$" + estoque.getTotValorProdutos() + "\n");
    }

    private void atualizarEstoque(Produto produto, int e) {

        int qtde = 0;

        if (e == 1){
            qtde = produto.getQtd();
        } else {
            qtde = qtde * (-1);
        }

        estoque.setTotProdutos(qtde);
        estoque.setTotValorProdutos(produto.getPreco() * (float)qtde);

        if (produto.getTipo().equals(Tipos.ELETRÔNICO.name())) {
            estoque.setTotEletronicos(qtde);
        }
        if (produto.getTipo().equals(Tipos.ALIMENTOS.name())) {
            estoque.setTotAlimentos(qtde);
        }
        if (produto.getTipo().equals(Tipos.UTILIDADES.name())) {
            estoque.setTotUtilidades(qtde);
        }
    }

    public void vender(String nome, int qtd) {
        Produto produto = retornarProduto(nome);
        produto.setQtd(qtd * (-1));
        System.out.println(qtd + produto.getNome() + "s  vendidos!");
    }

    public Produto retornarProduto(String produto) {
        Produto p = null;
        for (int c = 0;c < this.listaDeProdutos.size();c++) {
            if (this.listaDeProdutos.get(c).getNome().equals(produto)) {
                p = this.listaDeProdutos.get(c);
                break;
            }
        }
        return p;
    }
}
