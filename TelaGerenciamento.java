package gerenciamento_produtos;

import gerenciamento_produtos.arquivos.Arquivos;

import java.time.DateTimeException;

public class TelaGerenciamento implements Opcoes
{
    private final Estoque estoque;

    public TelaGerenciamento()
    {
        this.estoque = new Estoque();

        Arquivos.carregarDados(estoque);

        inicial();
    }

    public void inicial()
    {
        while (true)
        {
            try
            {
                int opcao = Mensagem.mensagemOpcoes("Tela Inicial", "Escolha uma opção", opcaoInicial);

                switch (opcao) {
                    case 0:
                        estoque.adicionar(opcaoTiposProdutos);
                        break;
                    case 1:
                        estoque.remover();
                        break;
                    case 2:
                        estoque.alterar(opcaoTiposProdutos);
                        break;
                    case 3:
                        estoque.listar(opcaoTiposProdutos);
                        break;
                    case 4, -1:
                        Mensagem.mensagemInformacao("Fechando", "Saindo...");
                        Arquivos.salvarTxt(estoque);
                        System.exit(0);
                }
            }
            catch (NumberFormatException e)
            {
                Mensagem.mensagemErro("Erro: casting invalido");
            }

            catch (IllegalArgumentException | IndexOutOfBoundsException e)
            {
                Mensagem.mensagemErro(e.getMessage());
            }

            catch (DateTimeException e)
            {
                Mensagem.mensagemErro("Erro: data inválida");
            }
        }
    }
}
