package src.mercado;

public class Estoque {
    // Atributos
    private int totProdutos;
    private float totValorProdutos;
    private int totEletronicos;
    private int totAlimentos;
    private int totUtilidades;

    // Construtor
    public Estoque() {
        this.totProdutos = 0;
        this.totValorProdutos = 0.0f;
        this.totEletronicos = 0;
        this.totAlimentos = 0;
        this.totUtilidades = 0;
    }

    // Getter
    public int getTotProdutos() { return totProdutos; }
    public float getTotValorProdutos() { return totValorProdutos; }
    public int getTotEletronicos() { return totEletronicos; }
    public int getTotAlimentos() { return totAlimentos; }
    public int getTotUtilidades() { return totUtilidades; }

    // Setter
    public void setTotProdutos(int totProdutos) { this.totProdutos += totProdutos; }
    public void setTotValorProdutos(float totValorProdutos) { this.totValorProdutos += totValorProdutos; }
    public void setTotEletronicos(int totEletronicos) { this.totEletronicos += totEletronicos; }
    public void setTotAlimentos(int totAlimentos) { this.totAlimentos += totAlimentos; }
    public void setTotUtilidades(int totUtilidades) { this.totUtilidades += totUtilidades; }
}
