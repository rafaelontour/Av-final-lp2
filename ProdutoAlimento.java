package src.mercado;

class ProdutoAlimento extends Produto {
    private String tipo;
    private float pVenda;
    private float taxa = Tipos.ALIMENTOS.getTaxa();

    public ProdutoAlimento(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = Tipos.ALIMENTOS.getTag();
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