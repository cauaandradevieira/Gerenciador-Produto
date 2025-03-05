package gerenciamento_produtos;

public interface Opcoes
{
    String [] opcaoInicial = { "adicionar" , "remover" , "alterar", "listar", "sair"};
    TiposProdutos [] opcaoTiposProdutos = TiposProdutos.values();
}
