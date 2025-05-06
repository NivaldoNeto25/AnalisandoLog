package br.upe.analisandoLog;

import java.util.LinkedHashMap;
import java.util.Map;

public class PorcentagemRequisicoesSO {
    private TratadorArquivo tratador;

    public PorcentagemRequisicoesSO(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void gerarRelatorio() {
        // Usa LinkedHashMap para manter a ordem
        LinkedHashMap<String, Integer> contagemSO = new LinkedHashMap<>();
        contagemSO.put("Windows", 0);
        contagemSO.put("Macintosh", 0);
        contagemSO.put("Ubuntu", 0);
        contagemSO.put("Fedora", 0);
        contagemSO.put("Mobile", 0);
        contagemSO.put("Linux, outros", 0);

        int totalRequisicoes = 0;

        // Conta os sistemas operacionais e total de requisições
        for (String userAgent : tratador.getUserAgents()) {
            totalRequisicoes++;

            if (userAgent.contains("Windows")) {
                contagemSO.put("Windows", contagemSO.get("Windows") + 1);
            } else if (userAgent.contains("Macintosh")) {
                contagemSO.put("Macintosh", contagemSO.get("Macintosh") + 1);
            } else if (userAgent.contains("Ubuntu")) {
                contagemSO.put("Ubuntu", contagemSO.get("Ubuntu") + 1);
            } else if (userAgent.contains("Fedora")) {
                contagemSO.put("Fedora", contagemSO.get("Fedora") + 1);
            } else if (userAgent.contains("Android") || userAgent.contains("Mobile")) {
                contagemSO.put("Mobile", contagemSO.get("Mobile") + 1);
            } else if (userAgent.contains("X11")) {
                contagemSO.put("Linux, outros", contagemSO.get("Linux, outros") + 1);
            }
        }

        // Monta o relatório
        StringBuilder relatorio = new StringBuilder();
        for (Map.Entry<String, Integer> entry : contagemSO.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                double percentual = (count / (double) totalRequisicoes) * 100;
                relatorio.append(String.format("%s %.4f\n", entry.getKey(), percentual));
            }
        }

        CriarArquivoTxt.salvar("sistemasOperacionais.txt", relatorio.toString());
    }
}

