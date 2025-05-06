package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NaoRespondidosTest {

    @Test
    public void testNaoRespondidos() {
        TratadorArquivo mock = new TratadorArquivo("teste.txt") {
            @Override
            public ArrayList<EntradaLog> getEntradas() {
                List<EntradaLog> entradas = new ArrayList<>();
                entradas.add(new EntradaLog("192.168.0.1", "10/Nov/2021", "GET", "/teste", "404", "123", "Chrome"));
                entradas.add(new EntradaLog("192.168.0.2", "11/Nov/2021", "GET", "/teste2", "500", "456", "Firefox"));
                entradas.add(new EntradaLog("192.168.0.3", "11/Oct/2021", "GET", "/teste3", "200", "789", "Safari"));
                return entradas;
            }
        };

        NaoRespondidos relatorio = new NaoRespondidos(mock);
        relatorio.gerarRelatorio();
    }
}

