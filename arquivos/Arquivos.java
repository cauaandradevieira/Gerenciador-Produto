package gerenciamento_produtos.arquivos;

import gerenciamento_produtos.Estoque;
import gerenciamento_produtos.Mensagem;
import gerenciamento_produtos.Produtos;
import gerenciamento_produtos.TiposProdutos;

import java.io.*;

public class Arquivos
{
    private static final String localArquivo = "C:\\Users\\cauaa\\IdeaProjects\\PretoChiq\\src\\gerenciamento_produtos\\arquivos\\arquivoProduto.txt";

    public static void carregarDados(Estoque estoque)
    {
        if(!new File(localArquivo).exists()) return;

        try(BufferedReader ler = new BufferedReader(new FileReader(localArquivo)))
        {
            String linha;
            Estoque estoqueNovo = new Estoque();
            boolean arquivoVazio = true;

            while ((linha = ler.readLine()) != null)
            {
                arquivoVazio = false;
                String [] linhaSeparada = linha.trim().split(";");

                estoqueNovo.getEstoque().add(retornarProduto(linhaSeparada));
            }
            if(!arquivoVazio) estoque.getEstoque().addAll(estoqueNovo.getEstoque());
        }
        catch (IOException e)
        {
            Mensagem.mensagemErro("Erro: localArquivo não encontrado. (CarregarDadosTxt)");
            System.exit(1);
        }
    }

    public static void salvarTxt(Estoque estoque)
    {
        try(BufferedWriter escrever = new BufferedWriter( new FileWriter(localArquivo)))
        {
            for(Produtos produto : estoque.getEstoque())
            {
               escrever.write(String.valueOf(produto).replace('\n',';').replace("-",";"));
               escrever.newLine();
            }
        }
        catch (IOException e)
        {
            Mensagem.mensagemErro("Erro: localArquivo não encontrado. (SalvarTxt)");
        }
    }

    public static Produtos retornarProduto(String[] linha)
    {
        return new Produtos(TiposProdutos.valueOf(linha[1].trim()), linha[3].trim(), Double.parseDouble(linha[5].trim()), Integer.parseInt(linha[7].trim()), Integer.parseInt(linha[9].trim()), linha[11].trim());
    }
}
