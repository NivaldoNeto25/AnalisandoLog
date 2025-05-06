package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RecursosGrandesRespondidosTest {

    @Test
    public void testRecursosGrandesRespondidos() {
        TratadorArquivo mock = new TratadorArquivo("teste.txt") {
            @Override
            public ArrayList<EntradaLog> getEntradas() {
                List<EntradaLog> entradas = new ArrayList<>();
                entradas.add(new EntradaLog("192.168.1.1", "12/Dec/2021", "GET", "/grande1", "200", "15000", "Edge"));
                entradas.add(new EntradaLog("192.168.1.2", "12/Dec/2021", "GET", "/pequeno", "200", "500", "Edge"));
                entradas.add(new EntradaLog("192.168.1.3", "12/Dec/2021", "GET", "/grande2", "200", "20000", "Edge"));
                return entradas;
            }
        };

        RecursosGrandesRespondidos relatorio = new RecursosGrandesRespondidos(mock);
        relatorio.gerarRelatorio();
    }
}

