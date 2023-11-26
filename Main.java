package src.mercado;
import java.util.Scanner;
import src.mercado.Interface;

public class Main {
    public static void main(String[] args) {


        Mercado mercado1 = new Mercado("Mercadinho LP2", "UNEB");
        Scanner op = new Scanner(System.in);
        int e;

        do {
            Main.menu();
//            Interface janela01 = new Interface();
            e = op.nextInt();


            switch (e) {
                case 1:
                    op.nextLine();

                    String nome;
                    float preco;
                    int qtd, o;

                    System.out.println("Tipo de produto a cadastrar: ");
                    System.out.println(" 1 - Eletrônico");
                    System.out.println(" 2 - Alimentos");
                    System.out.println(" 3 - Utilidades");
                    System.out.print("\nEscolha uma opção: ");

                    o = op.nextInt(); // Opção para escolher qual construtor chamar no método adicionar da classe mercado

                    while (o != 1 || o != 2 || o != 3) {
                        op.nextLine();
                        if (o == 1 || o == 2 || o == 3) {
                            break;
                        }
                        System.out.print("Digite uma opção válida: ");
                        o = op.nextInt();
                    }

                    System.out.print("Nome do produto: ");
                    nome = op.nextLine();

                    if (mercado1.verificarProduto(nome.toUpperCase())) {
                        String r;
                        System.out.print("Produto já cadastrado. Adicionar mais itens? (S/N): ");
                        r = op.nextLine();

                        if (r.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            int r2;
                            System.out.print("Quantos itens quer adicionar?: ");
                            r2 = Integer.parseInt(op.nextLine());
                            Produto pm = mercado1.retornarProduto(nome);
                            pm.setQtd(pm.getQtd() + r2);

                            mercado1.getEstoque().setTotProdutos(r2);
                            mercado1.getEstoque().setTotValorProdutos(pm.getPreco() * r2);
                            if (pm.getTipo().equals(Tipos.ELETRONICO.getTag())) {
                                mercado1.getEstoque().setTotEletronicos(r2);
                                break;
                            }
                            if (pm.getTipo().equals(Tipos.ALIMENTOS.getTag())) {
                                mercado1.getEstoque().setTotAlimentos(r2);
                                break;
                            }
                            if (pm.getTipo().equals(Tipos.UTILIDADES.getTag())) {
                                mercado1.getEstoque().setTotUtilidades(r2);
                                break;
                            }

                        }
                    }

                    do {
                        System.out.print("Preço: R$");
                        preco = Float.parseFloat(op.nextLine());

                        if (preco < 0.1) {
                            System.out.println("Digite um preço válido!");
                        }
                    } while (preco < 0.1);


                    do  {
                        System.out.print("Quantidade: ");
                        qtd = op.nextInt();

                        if (qtd < 1) {
                            System.out.println("Digite uma quantidade válida!");
                        }
                    } while (qtd < 1);


                    mercado1.adicionar(nome, preco, qtd, o); // Aqui

                    break;
                case 2:
                    if (!mercado1.verificar()) {
                        System.out.println("Nenhum produto cadastrado para consultar.");
                        op.nextLine();
                    } else {
                        op.nextLine();
                        String nomeP;

                        System.out.print("Digite o nome do produto a ser consultado: ");
                        nomeP = op.nextLine();

                        if (mercado1.verificarProduto(nomeP.toUpperCase())) {
                            mercado1.consultar(nomeP.toUpperCase());
                        } else {
                            System.out.println("Produto não cadastrado.");
                        }
                    }
                    break;
                case 3:
                    if (!mercado1.verificar()) {
                        System.out.println("Nenhum produto para alterar.");
                    } else {
                        mercado1.imprimir();
                        String pa;
                        System.out.print("\nInsira o nome do produto que deseja alterar: ");

                        op.nextLine();
                        pa = op.nextLine();
                        
                        if (mercado1.verificarProduto(pa.toUpperCase())) {
                            mercado1.alterar(pa.toUpperCase());
                        } else {
                            System.out.println("Produto não cadastrado.");
                        }
                    }
                    break;
                case 4:
                    if (!mercado1.verificar()) {
                        System.out.println("Não há produtos para remover.");
                    } else {
                        String pr;
                        mercado1.imprimir();
                        System.out.print("Qual produto deseja remover?: ");

                        op.nextLine();
                        pr = op.nextLine();

                        mercado1.excluir(pr.toUpperCase());
                    }
                    break;
                case 5:
                    mercado1.imprimir();
                    break;
                case 6:
                    mercado1.consultarEstoque();
                    break;
                case 7:
                     mercado1.imprimir();
                     op.nextLine();
                     System.out.print("\nQual produto deseja vender?: ");

                     String p = op.nextLine();

                     if (!mercado1.verificarProduto(p.toUpperCase())) {
                         System.out.println("Produto não cadastrado.");
                         break;
                     }

                     int qtd2;
                     System.out.print("Quantos items deseja vender: ");
                     qtd2 = Integer.parseInt(op.nextLine());

                     mercado1.vender(p, qtd2);
                     break;

                case 8:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (e != 8);
    }


    public static void menu(){
        System.out.println("\n*********************************");
        System.out.println("          MERCADINHO LP2");
        System.out.println("*********************************\n");

        System.out.println("Escolha uma opção: \n");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Consultar produto");
        System.out.println("3 - Alterar dados de um produto");
        System.out.println("4 - Excluir produto");
        System.out.println("5 - Listar produtos");
        System.out.println("6 - Consultar estoque");
        System.out.println("7 - Vender um produto");
        System.out.println("8 - Sair\n");

        System.out.print("Opção: ");
    }
}
