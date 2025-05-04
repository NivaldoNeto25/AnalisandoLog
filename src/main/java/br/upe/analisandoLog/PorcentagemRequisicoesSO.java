package br.upe.analisandoLog;

import java.util.HashMap;
import java.util.Map;

public class SistemasOperacionais {
    private TratadorArquivo tratador;

    public SistemasOperacionais(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void gerarRelatorio() {
        HashMap<String, Integer> contagemSO = new HashMap<>();
        int totalRequisicoes = 0;

        // Loop para contar os sistemas operacionais e o total de requisições
        for (String userAgent : tratador.getUserAgents()) {
            totalRequisicoes++;
            if (userAgent.contains("Windows")) {
                contagemSO.put("Windows", contagemSO.getOrDefault("Windows", 0) + 1);
            } else if (userAgent.contains("Macintosh")) {
                contagemSO.put("Macintosh", contagemSO.getOrDefault("Macintosh", 0) + 1);
            } else if (userAgent.contains("Ubuntu")) {
                contagemSO.put("Ubuntu", contagemSO.getOrDefault("Ubuntu", 0) + 1);
            } else if (userAgent.contains("Fedora")) {
                contagemSO.put("Fedora", contagemSO.getOrDefault("Fedora", 0) + 1);
            } else if (userAgent.contains("Android") || userAgent.contains("Mobile")) {
                contagemSO.put("Mobile", contagemSO.getOrDefault("Mobile", 0) + 1);
            } else if (userAgent.contains("X11")) {
                contagemSO.put("Linux, outros", contagemSO.getOrDefault("Linux, outros", 0) + 1);
            }
        }

        // Gerar o relatório com o percentual de cada SO
        StringBuilder relatorio = new StringBuilder();
        for (Map.Entry<String, Integer> entry : contagemSO.entrySet()) {
            String so = entry.getKey();
            int count = entry.getValue();
            double percentual = (count / (double) totalRequisicoes) * 100;
            relatorio.append(String.format("%s %.4f\n", so, percentual));
        }

        CriarArquivoTxt.salvar("sistemasOperacionais.txt", relatorio.toString());
    }
}
