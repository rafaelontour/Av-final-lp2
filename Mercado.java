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
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().equals(pa)) {
                Scanner op = new Scanner(System.in);
                String nome;
                float preco;
                int qtd;

                // Para alterar um produto, precisamos primeiro remover a quantidade dele e o preço multiplicado pelo seu valor  antes de colocar os novos dados do produto novo
                // Nessa parte pegamos os novos dados
                System.out.print("Digite o nome do novo produto: ");
                nome = op.nextLine();
                produto.setNome(nome.toUpperCase());

                System.out.print("Digite o novo preço: R$" );
                preco = op.nextFloat();

                System.out.print("Digite a quantidade nova: ");
                qtd = op.nextInt();

                estoque.setTotProdutos(-(produto.getQtd())); // Removendo a quantidade de produtos do contador total de produtos
                System.out.println(estoque.getTotProdutos());

                estoque.setTotProdutos(qtd);
                estoque.setTotValorProdutos(-((float)produto.getQtd() * produto.getPreco())); // Tirando o valor do produto velho multiplicado pela sua quantidade do total em reais do contador de valor
                produto.setPreco(preco);
                System.out.println(estoque.getTotValorProdutos());
                estoque.setTotValorProdutos((float)qtd * produto.getPreco());
                produto.setQtd(qtd);

                if (produto.getTipo().equals(Tipos.ELETRONICO.getTag())) { // É preciso remover a quantidade do produto antigo, nesse caso, eletrônico, do contador de produtos eletrônicos para colocar a nova quantidade
                    estoque.setTotEletronicos(-(estoque.getTotEletronicos()));
                    estoque.setTotEletronicos(qtd); // Colocando quantidade nova no contador
                }
                if (produto.getTipo().equals(Tipos.ALIMENTOS.getTag())) { // A mesma situação aqui
                    estoque.setTotAlimentos(-(estoque.getTotAlimentos()));
                    estoque.setTotAlimentos(qtd);
                }
                if (produto.getTipo().equals(Tipos.UTILIDADES.getTag())) { // Aqui também
                    estoque.setTotUtilidades(-(estoque.getTotUtilidades()));
                    estoque.setTotUtilidades(qtd);
                }

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
        this.imprimir();
        if (check == 0) {
            System.out.println("Produto não cadastrado!");
        }
    }

    @Override
    public void imprimir() {
        if (!listaDeProdutos.isEmpty()) {
            System.out.println("         Produtos cadastrados\n");
            for (int c = 0;c < listaDeProdutos.size();c++) {
                System.out.println((c + 1) + " - " + listaDeProdutos.get(c).getNome() + " | Qtd: " + listaDeProdutos.get(c).getQtd() + " | Preço: R$" + listaDeProdutos.get(c).getPreco());
            }
        } else {
            System.out.println("Nenhum produto cadastrado.\n");
        }
    }

    boolean verificar() { // Verifica tamanho da lista
        if (this.listaDeProdutos.isEmpty()) {
            return false;
        } else { return true; }
    }

    boolean verificarProduto(String pa) { // Verifica se tem um produto na lista
        boolean r = false;
        for (Produto p : this.listaDeProdutos) {
            if (p.getNome().equals(pa)) {
                return true;
            }
        }
        return false;
    }

    public void consultarEstoque() {
        System.out.println("         Estoque");
        System.out.println("***************************");
        System.out.println("\nQuantidade total de produtos: " + estoque.getTotProdutos());
        System.out.println("Quantidade de produtos eletrônicos: " + estoque.getTotEletronicos());
        System.out.println("Quantidade de produtos alimentícios: " + estoque.getTotAlimentos());
        System.out.println("Quantidade de produtos utilitários: " + estoque.getTotUtilidades());
        System.out.println("Valor total do estoque: R$" + estoque.getTotValorProdutos());
        System.out.println("Valor total de lucro de vendas: R$" + estoque.getTotValorVenda());
    }

    private void atualizarEstoque(Produto produto, int e) {

        int qtde = 1;

        if (e == 2)  {
            qtde *= (-1);
        } else if (e != 1) {
            qtde = e * (-1);
        } else {
            qtde = produto.getQtd();
        }

        estoque.setTotProdutos(qtde);
        estoque.setTotValorProdutos(produto.getPreco() * (float)qtde);

        if (produto.getTipo().equals(Tipos.ELETRONICO.getTag())) {
            estoque.setTotEletronicos(qtde);
            return;
        }
        if (produto.getTipo().equals(Tipos.ALIMENTOS.getTag())) {
            estoque.setTotAlimentos(qtde);
            return;
        }
        if (produto.getTipo().equals(Tipos.UTILIDADES.getTag())) {
            estoque.setTotUtilidades(qtde);
        }
    }

    public void vender(String nome, int qtd) {
        Produto produto = retornarProduto(nome);

        while (produto.getQtd() - qtd< 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Inválido. Digite um número acima da quantidade em estoque: ");
            qtd = Integer.parseInt(scanner.nextLine());
        }

        if (produto.getQtd() - qtd == 0) {
            listaDeProdutos.remove(produto);
        }

        System.out.println("QTD: " + produto.getQtd() + " | PREÇO: " + produto.getPreco());
        estoque.setTotValorVenda((float)qtd * produto.getPVenda());
        produto.setQtd(produto.getQtd() - qtd);

        if (qtd > 1) {
            System.out.println(qtd + " itens de " + produto.getNome() + " vendidos!");
        } else {
            System.out.println(qtd + " item de " + produto.getNome() + " vendidos!");
        }
        atualizarEstoque(produto, qtd);
    }

    public Produto retornarProduto(String produto) {
        Produto res = null;
        for (Produto p : this.listaDeProdutos) {

            produto = produto.toUpperCase();
            if (p.getNome().equals(produto)) {
                System.out.println(p.getNome());
                System.out.println(produto);
                res = p;
                break;
            }
        }
        return res;
    }
}


