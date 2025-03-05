package gerenciamento_produtos;

import java.util.Objects;

public class Produtos
{
    private String nome;
    private double valor;
    private int quantidade;
    private int codigo;
    private String dataValidade;
    private TiposProdutos tiposProdutos;

    public Produtos(TiposProdutos tiposProdutos, String nome, double valor, int quantidade, int codigo, String dataValidade)
    {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.dataValidade = dataValidade;
        this.tiposProdutos = tiposProdutos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return codigo == produtos.codigo || Objects.equals(nome, produtos.nome);
    }

    @Override
    public String toString() {
        return  "tiposProdutos - " + tiposProdutos + " \n " +
                "nome - " + nome + " \n " +
                "valor - " + valor + " \n "+
                "quantidade - " + quantidade + " \n " +
                "codigo - " + codigo + " \n " +
                "dataValidade - " + dataValidade + " \n ";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public TiposProdutos getTiposProdutos() {
        return tiposProdutos;
    }

    public void setTiposProdutos(TiposProdutos tiposProdutos) {
        this.tiposProdutos = tiposProdutos;
    }
}
