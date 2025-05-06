package br.upe.analisandoLog;

import java.util.ArrayList;
import java.util.List;

public class NaoRespondidos extends RelatorioBase {

    public NaoRespondidos(TratadorArquivo tratador) {
        super(tratador);
    }

    @Override
    public void gerarRelatorio() {
        ArrayList<EntradaLog> entradas = tratador.getEntradas();
        List<String> relatorio = new ArrayList<>();

        for (EntradaLog entrada : entradas) {
            try {
                int codigo = Integer.parseInt(entrada.getStatusCode());
                String data = entrada.getData();

                if (codigo >= 400 && codigo <= 499 && data.contains("Nov/2021")) {
                    String linha = codigo + " \"" + entrada.getRecurso() + "\" Nov/2021";
                    relatorio.add(linha);
                }
            } catch (NumberFormatException e) {
                // Ignorar entradas inválidas
            }
        }

        String conteudoRelatorio = String.join("\n", relatorio);
        CriarArquivoTxt.salvar("naoRespondidosNovembro.txt", conteudoRelatorio);
    }
}