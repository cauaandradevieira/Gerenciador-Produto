package gerenciamento_produtos;

import javax.swing.*;

public class Mensagem
{
    public static void mensagemInformacao(String titulo, String mensagem)
    {
        JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mensagemInformacao(String titulo, Produtos mensagem)
    {
        JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.INFORMATION_MESSAGE);
    }

    public static String mensagemInput(String titulo, String mensagem) throws IllegalArgumentException
    {
        return JOptionPane.showInputDialog(null,mensagem,titulo,JOptionPane.QUESTION_MESSAGE);
    }

    public static int mensagemOpcoes(String titulo, String mensagem, String [] opcoes)
    {
        return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opcoes,opcoes[0]);
    }

    public static int mensagemOpcoes(String titulo, String mensagem, TiposProdutos [] opcoes)
    {
        return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opcoes,opcoes[0]);
    }

    public static void mensagemErro(String mensagem)
    {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public static void mensagenConfirmacao(String resultadoInput, String mensagem)
    {
        if(resultadoInput == null) JOptionPane.showConfirmDialog(null, mensagem, "Confirmação",JOptionPane.OK_CANCEL_OPTION);
        JOptionPane.showConfirmDialog(null, mensagem, "Confirmação",JOptionPane.OK_CANCEL_OPTION);
    }
    public static Produtos inputProduto(String mensagem, TiposProdutos[] arrayTiposProdutos)
    {
        String [] inputStrings = inputProdutoValorString(mensagem);

        if(inputStrings == null) return null;

        TiposProdutos tiposProdutos = inputTiposProdutos(mensagem, arrayTiposProdutos);
        String nome = inputStrings[0];
        int codigo = Integer.parseInt(inputStrings[1]);
        int quantidade = Integer.parseInt(inputStrings[2]);
        double valor = Double.parseDouble(inputStrings[3]);
        int dia = Integer.parseInt(inputStrings[4]);
        int mes = Integer.parseInt(inputStrings[5]);
        int ano = Integer.parseInt(inputStrings[6]);

        return new Produtos(tiposProdutos, nome, valor, quantidade, codigo, Data.retornarDataFormatada(dia,mes,ano));
    }

    public static String[] inputProdutoValorString(String mensagem)
    {
        String nomeString = Mensagem.mensagemInput(mensagem, "Digite o nome");
        if(verificarStringNull(nomeString)) return null;
        String codigoString = Mensagem.mensagemInput(mensagem, "Digite o codigo");
        if(verificarStringNull(codigoString)) return null;
        String quantidadeString = Mensagem.mensagemInput(mensagem, "Digite o quantidade");
        if(verificarStringNull(quantidadeString)) return null;
        String valorString = Mensagem.mensagemInput(mensagem, "Digite o valor");
        if(verificarStringNull(valorString)) return null;
        String diaString = Mensagem.mensagemInput(mensagem , "Digite o dia (data validade)");
        if(verificarStringNull(diaString)) return null;
        String mesString = Mensagem.mensagemInput(mensagem, "Digite o mes (data validade)");
        if(verificarStringNull(mesString)) return null;
        String anoString = Mensagem.mensagemInput(mensagem , "Digite o ano (data validade)");
        if(verificarStringNull(anoString)) return null;

        return new String[]{nomeString,codigoString,quantidadeString,valorString,diaString,mesString,anoString};
    }

    public static TiposProdutos inputTiposProdutos(String mensagem, TiposProdutos[] arrayTiposProdutos)
    {
        int indiceTipoProduto = Mensagem.mensagemOpcoes(mensagem, "Escolha uma opção", arrayTiposProdutos);
        if (indiceTipoProduto == -1 ) return null;
        return TiposProdutos.values()[indiceTipoProduto];
    }

    public static int inputCodigo()
    {
        String codigoValorString = Mensagem.mensagemInput("Removendo produto", "Digite o codigo");

        if(codigoValorString == null) return -1;
        if(codigoValorString.isBlank()) throw new IllegalArgumentException("Erro: String vazia");

        return Integer.parseInt(codigoValorString);
    }

    public static boolean verificarStringNull(String inputValorString)
    {
        if(inputValorString == null) throw new IllegalArgumentException("Operação cancelada.");
        if(inputValorString.isBlank()) throw new IllegalArgumentException("Erro: String vazia");

        return false;
    }
}
