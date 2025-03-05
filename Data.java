package gerenciamento_produtos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data
{
    public static String retornarDataFormatada(int dia, int mes, int ano) throws IllegalArgumentException, DateTimeException
    {
        LocalDate data = LocalDate.of(ano,mes,dia);
        if(data.isBefore(LocalDate.now())) throw new IllegalArgumentException("Erro: data inválida. (data antiga)");

        return data.format( DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
