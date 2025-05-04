package br.upe.analisandoLog;

import java.util.ArrayList;
import java.util.List;

public class NaoRespondidos {
    private TratadorArquivo tratador;

    public NaoRespondidos(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void gerarRelatorio() {
        ArrayList<String> codigos = tratador.getCodigos();
        ArrayList<String> recursos = tratador.getRecursos();
        ArrayList<String> datas = tratador.getDatas();

        List<String> relatorio = new ArrayList<>();
        relatorio.add("Requisições não respondidas em Novembro de 2021:\n");

        for (int i = 0; i < codigos.size(); i++) {
            try {
                int codigo = Integer.parseInt(codigos.get(i));
                String data = datas.get(i);

                // Verifica código de erro 4xx e se a data é de novembro de 2021
                if (codigo >= 400 && codigo <= 499 && data.contains("Nov/2021")) {
                    String linha = codigo + " " + "\"" + recursos.get(i) + "\" Nov/2021";
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
