package src.mercado;

public class Menu {

    static void mostrarMenu(Mercado mercado) {
        System.out.println("\n*********************************");
        System.out.println("          MERCADINHO LP2");
        System.out.println("*********************************\n");

        mercado.imprimir();

        System.out.println("Escolha uma opção: \n");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Consultar produto");
        System.out.println("3 - Alterar dados de um produto");
        System.out.println("4 - Excluir dados de um produto");
        System.out.println("5 - Listar produtos\n");

        System.out.print("Opçao: ");
    }

    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
