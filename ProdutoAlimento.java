package src.mercado;

class ProdutoAlimento extends Produto {
    private String tipo = "ALIMENTOS";
    public ProdutoAlimento(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
}