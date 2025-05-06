package br.upe.analisandoLog;

import java.util.ArrayList;
import java.util.List;

public class RecursosGrandesRespondidos extends RelatorioBase {

    public RecursosGrandesRespondidos(TratadorArquivo tratador) {
        super(tratador);
    }

    @Override
    public void gerarRelatorio() {
        ArrayList<EntradaLog> entradas = tratador.getEntradas();
        List<String> relatorio = new ArrayList<>();

        for (EntradaLog entrada : entradas) {
            try {
                int codigo = Integer.parseInt(entrada.getStatusCode());
                int tamanho = Integer.parseInt(entrada.getTamanho());

                if (codigo >= 200 && codigo <= 299 && tamanho > 2000) {
                    String linha = codigo + " " + tamanho + " " + entrada.getIp();
                    relatorio.add(linha);
                }
            } catch (NumberFormatException e) {
                // Ignorar entradas inválidas
            }
        }

        String conteudoRelatorio = String.join("\n", relatorio);
        CriarArquivoTxt.salvar("recursosGrandes.txt", conteudoRelatorio);
    }
}