package src.mercado;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mercado mercado1 = new Mercado("Mercadinho LP2", "UNEB");
        Scanner op = new Scanner(System.in);
        int e;

        while (true) {
            Menu.mostrarMenu(mercado1);
            e = op.nextInt();

            switch (e) {
                case 1:
                    op.nextLine();

                    String nome;
                    float preco;
                    int qtd;

                    System.out.print("Nome do produto: ");
                    nome = op.nextLine();
                    System.out.print("Preço: R$");
                    preco = op.nextFloat();
                    System.out.print("Quantidade: ");
                    qtd = op.nextInt();

                    mercado1.adicionar(nome, preco, qtd);
                    Menu.limparTela();
                    break;
                case 2:
                    if (!mercado1.verificar()) {
                        System.out.println("Nenhum produto cadastrado para consultar.");
                        op.nextLine();
                        Menu.limparTela();
                    } else {
                        op.nextLine();
                        String nomeP;
                        System.out.print("Digite o nome do produto a ser consultado: ");
                        nomeP = op.nextLine();

                        if (mercado1.verificarProduto(nomeP.toUpperCase())) {
                            Menu.limparTela();
                            mercado1.consultar(nomeP.toUpperCase());
                        } else {
                            System.out.println("Produto não cadastrado.");
                        }

                    }
                    break;
                case 3:
                    if (!mercado1.verificar()) {
                        System.out.println("Nenhum produto para alterar.");
                        Menu.limparTela();
                    } else {
                        mercado1.imprimir();
                        String pa;
                        System.out.print("Insira o nome do produto que deseja alterar: ");

                        pa = op.nextLine();
                        pa = op.nextLine();
                        
                        if (mercado1.verificarProduto(pa.toUpperCase())) {
                            mercado1.alterar(pa.toUpperCase());
                            Menu.limparTela();
                        } else {
                            System.out.println("Produto não cadastrado.");
                        }


                    }
                    break;


                case 4:
                    if (!mercado1.verificar()) {
                        System.out.println("Não há produtos para remover.");
                        Menu.limparTela();
                    } else {
                        if (mercado1.getListaDeProdutos().size() == 1) {
                            mercado1.getListaDeProdutos().remove(0);
                            System.out.println("Produto removido.");
                        } else {
                            String pr;
                            mercado1.imprimir();
                            System.out.print("Qual produto deseja remover?: ");
                            
                            pr = op.nextLine();
                            pr = op.nextLine();

                            mercado1.excluir(pr.toUpperCase());
                            Menu.limparTela();
                        }

                    }
                    break;
                case 5:
                    mercado1.imprimir();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            break;
        }
    }
}
