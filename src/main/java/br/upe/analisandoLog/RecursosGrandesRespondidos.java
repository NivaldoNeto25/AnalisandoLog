package br.upe.analisandoLog;

import java.util.ArrayList;
import java.util.List;

public class RecursosGrandesRespondidos {
    private TratadorArquivo tratador;

    public RecursosGrandesRespondidos(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void gerarRelatorio() {
        ArrayList<String> codigos = tratador.getCodigos();
        ArrayList<String> tamanhos = tratador.getTamanhos();
        ArrayList<String> ips = tratador.getIps();

        List<String> relatorio = new ArrayList<>();

        for (int i = 0; i < codigos.size(); i++) {
            try {
                int codigo = Integer.parseInt(codigos.get(i));
                int tamanho = Integer.parseInt(tamanhos.get(i));

                if (codigo >= 200 && codigo <= 299 && tamanho > 2000) {
                    String linha = codigo + " " + tamanho + " " + ips.get(i);
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