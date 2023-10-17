package src.mercado;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercado implements InterfaceMercado {

    //Atributos 
    private String nome;
    private String endereco;
    private  ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    // Construtor
    public Mercado(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    // Outros métodos
    @Override
    public void adicionar(String nome, float preco, int qtd) {
        Produto p = new Produto(nome, preco, qtd);
        listaDeProdutos.add(p);
    }

    @Override
    public void consultar(String nomeP) {
        for (int i = 0;i < listaDeProdutos.size();i++) {
            if (listaDeProdutos.get(i).getNome().equals(nomeP)) {
                System.out.println("\nProduto: " + listaDeProdutos.get(i).getNome());
                System.out.println("Preço: R$" + listaDeProdutos.get(i).getPreco());
                System.out.println("Quantidade: " + listaDeProdutos.get(i).getQtd() + "\n");
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

                System.out.println("Digite o nome do novo produto: ");
                nome = op.nextLine();
                listaDeProdutos.get(c).setNome(nome);

                System.out.println("Digite o novo preço: R$" );
                preco = op.nextFloat();
                listaDeProdutos.get(c).setPreco(preco);

                System.out.println("Digite a quantidade nova: ");
                qtd = op.nextInt();
                listaDeProdutos.get(c).setQtd(qtd);

                break;
            }
        }
    }

    @Override
    public void excluir(String item) {
        for (int c = 0;c < listaDeProdutos.size();c++) {
            if (listaDeProdutos.get(c).getNome().equals(item)) {
                System.out.println("Produto '" + listaDeProdutos.get(c).getNome() + "' removido!");
                listaDeProdutos.remove(c);
            }
        }
    }

    @Override
    public void imprimir() {
        if (listaDeProdutos.size() != 0) {
            System.out.println("         Produtos cadastrados\n");
            for (int c = 0;c < listaDeProdutos.size();c++) {
                System.out.println((c + 1) + " - " + listaDeProdutos.get(c).getNome());
            }
            System.out.println("");
        } else {
            System.out.println("Nenhum produto cadastrado.\n");
        }

    }

    boolean verificar() {
        if (this.listaDeProdutos.size() == 0) {
            return false;
        } else { return true; }
    }
}
