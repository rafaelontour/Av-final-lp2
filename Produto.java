package src.mercado;
import java.util.ArrayList;

abstract class Produto {

    // Atributos
    private String nome;
    private String tipo;
    private float preco;
    private int qtd;

    // Construtor
    public Produto(String nome, float preco, int qtd) {
        this.nome  = nome.toUpperCase();
        this.preco = preco;
        this.qtd   = qtd;
    }

    // Getter
    public String getNome() { return this.nome; }
    public float getPreco() { return this.preco; }
    public int getQtd() { return this.qtd; }
    public String getTipo() { return this.tipo; }

    // Setter
    void setNome(String nome) { this.nome = nome; }
    void setPreco(float preco) { this.preco = preco; }
    void setQtd(int qtd) { this.qtd = qtd; }

    // Outros métodos

}