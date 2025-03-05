package gerenciamento_produtos;

import java.util.ArrayList;

public class Estoque
{
    private ArrayList <Produtos> estoque;

    public Estoque()
    {
        this.estoque = new ArrayList<>();
    }

    public void adicionar(TiposProdutos[] tiposProdutos) throws IllegalArgumentException
    {
        Produtos produto = Mensagem.inputProduto("Adicionando Produto", tiposProdutos);
        verificarProdutoExist(produto);
        verificarNull(produto);
        estoque.add(produto);
        Mensagem.mensagemInformacao("Sucesso", "Produto adicionado com sucesso.");
    }

    public void remover() throws IllegalArgumentException
    {
        verificarEstoqueVazio();
        int codigo = Mensagem.inputCodigo();

        if(codigo == -1) return;

        Produtos produto = obterProduto(codigo);
        verificarNull(produto);
        estoque.remove(produto);
        Mensagem.mensagemInformacao("Sucesso", "Produto removido com sucesso.");
    }

    public void alterar(TiposProdutos[] tiposProdutos) throws IllegalArgumentException
    {

        verificarEstoqueVazio();
        int codigo = Mensagem.inputCodigo();

        if(codigo == -1) return;
        Produtos produtoEncontrado = obterProduto(codigo);
        verificarNull(produtoEncontrado);

        Produtos produtoNovo = Mensagem.inputProduto("Alterando Produto", tiposProdutos);

        verificarNull(produtoNovo);

        produtoEncontrado.setCodigo(produtoNovo.getCodigo());
        produtoEncontrado.setNome(produtoNovo.getNome());
        produtoEncontrado.setQuantidade(produtoNovo.getQuantidade());
        produtoEncontrado.setValor(produtoNovo.getValor());
        produtoEncontrado.setDataValidade(produtoNovo.getDataValidade());
        produtoEncontrado.setTiposProdutos(produtoNovo.getTiposProdutos());

        Mensagem.mensagemInformacao("Sucesso", "Produto alterado com sucesso.");
    }

    public void listar(TiposProdutos[] arrayTiposProdutos)
    {
        verificarEstoqueVazio();

        TiposProdutos tiposProdutos = Mensagem.inputTiposProdutos("Listando Produtos", arrayTiposProdutos);

        verificarEstoqueVazio(tiposProdutos);

        for (Produtos produto : estoque)
        {
            if(produto.getTiposProdutos().equals(tiposProdutos))
            {
                Mensagem.mensagemInformacao("Listando produtos", produto);
            }
        }
    }

    public Produtos obterProduto(int codigo)
    {
        for(Produtos produto : estoque)
        {
            if(produto.getCodigo() == codigo)
            {
                return produto;
            }
        }
        return null;
    }

    public void verificarNull(Produtos produto)
    {
        if(produto == null) throw new IndexOutOfBoundsException("Erro: codigo inválido.");
    }

    public void verificarEstoqueVazio()
    {
        if(estoque.isEmpty()) throw new IllegalArgumentException("Erro: estoque vazio.");
    }

    public void verificarEstoqueVazio(TiposProdutos tiposProdutos)
    {
        for(Produtos produtos : estoque)
        {
            if(produtos.getTiposProdutos().equals(tiposProdutos)) return;
        }
        throw new IllegalArgumentException("Erro: estoque vazio do tipo alimento " + tiposProdutos);
    }
    public void verificarProdutoExist(Produtos produto)
    {
        if(estoque.contains(produto))
        {
            throw new IllegalArgumentException("Erro: ja contem codigo ou nome usado no estoque.");
        }
    }

    public ArrayList<Produtos> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produtos> estoque) {
        this.estoque = estoque;
    }
}
