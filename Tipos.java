package src.mercado;

public enum Tipos {
    ELETRONICO(0.6f, "ELETRONICO"),
    ALIMENTOS(0.5f, "ALIMENTOS"),
    UTILIDADES(0.3f, "UTILIDADES");

    private float taxa;
    private String tag;

    Tipos(float taxa, String tag) {
        this.taxa = taxa;
        this.tag = tag;
    }

    public float getTaxa() {
        return taxa;
    }

    public String getTag() {
        return tag;
    }
}
