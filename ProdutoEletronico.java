package src.mercado;

class ProdutoEletronico extends Produto {
    private String tipo;
    private float pVenda;
    private float taxa = Tipos.ELETRONICO.getTaxa();

    public ProdutoEletronico(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = Tipos.ELETRONICO.getTag();
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