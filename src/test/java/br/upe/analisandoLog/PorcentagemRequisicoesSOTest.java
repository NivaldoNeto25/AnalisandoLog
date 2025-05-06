package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PorcentagemRequisicoesSOTest {

    @Test
    public void testRelatorioSistemasOperacionais() {
        TratadorArquivo mock = new TratadorArquivo("test.txt") {
            @Override
            public ArrayList<EntradaLog> getEntradas() {
                List<EntradaLog> entradas = new ArrayList<>();
                entradas.add(new EntradaLog("1.1.1.1", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"));
                entradas.add(new EntradaLog("2.2.2.2", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (X11; Linux x86_64)"));
                entradas.add(new EntradaLog("3.3.3.3", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (Android 10; Mobile)"));
                entradas.add(new EntradaLog("4.4.4.4", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)"));
                entradas.add(new EntradaLog("5.5.5.5", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (Ubuntu; Linux x86_64)"));
                entradas.add(new EntradaLog("6.6.6.6", "01/Jan/2022", "GET", "/index", "200", "1234", "Mozilla/5.0 (Fedora; Linux x86_64)"));
                return entradas;
            }
        };

        PorcentagemRequisicoesSO porc = new PorcentagemRequisicoesSO(mock);
        porc.gerarRelatorio(); // Saída pode ser validada visualmente ou por comparação com resultado esperado
    }
}

