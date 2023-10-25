package src.mercado;

class ProdutoEletronico extends Produto {
    private String tipo = "ELETRÔNICO";
    public ProdutoEletronico(String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

}