package gerenciamento_produtos;

public enum TiposProdutos
{
    VERDURAS(0),
    LIMPEZA(1),
    CARNES(2),
    BISCOITOS(3),
    DOCES(4),
    BEBIDAS(5);

    private final int numero;

    TiposProdutos(int numero)
    {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
