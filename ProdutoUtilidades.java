package src.mercado;

class ProdutoUtilidades extends Produto {
    private String tipo = "UTILIDADES";
    public ProdutoUtilidades(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
}