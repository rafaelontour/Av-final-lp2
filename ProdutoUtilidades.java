package src.mercado;

class ProdutoUtilidades extends Produto {
    private String tipo;
    private float pVenda;
    private float taxa = Tipos.UTILIDADES.getTaxa();

    public ProdutoUtilidades(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = Tipos.UTILIDADES.getTag();
        this.pVenda = 0.0f;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
    @Override
    public float getPVenda() {
        pVenda = this.getPreco() + (this.taxa * this.getPreco());
        return this.pVenda;
    }
}