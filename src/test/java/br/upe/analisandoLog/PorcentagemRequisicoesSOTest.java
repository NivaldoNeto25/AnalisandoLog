package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;



public class PorcentagemRequisicoesSOTest {
    @Test
    public void testRelatorioSistemasOperacionais() {
        TratadorArquivo mock = new TratadorArquivo("test.txt") {
            @Override
            public ArrayList<String> getUserAgents() {
                ArrayList<String> agents = new ArrayList<>();
                agents.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
                agents.add("Mozilla/5.0 (X11; Linux x86_64)");
                agents.add("Mozilla/5.0 (Android 10; Mobile)");
                agents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)");
                agents.add("Mozilla/5.0 (Ubuntu; Linux x86_64)");
                agents.add("Mozilla/5.0 (Fedora; Linux x86_64)");
                return agents;
            }
        };

        PorcentagemRequisicoesSO porc = new PorcentagemRequisicoesSO(mock);
        porc.gerarRelatorio(); // Verificação visual ou leitura de arquivo
    }
}
