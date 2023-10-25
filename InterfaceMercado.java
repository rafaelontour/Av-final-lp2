package src.mercado;

public interface InterfaceMercado {
    public void adicionar(String nome, float preco, int qtd, int escolha);
    public void consultar(String produto);
    public void alterar(String pa);
    public void excluir(String item);
    public void imprimir();
}
