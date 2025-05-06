package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NaoRespondidosTest {
    @Test
    public void testRelatorioNaoRespondidosNovembro() {
        TratadorArquivo mock = new TratadorArquivo("test.txt") {
            @Override
            public ArrayList<String> getCodigos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("404");
                lista.add("403");
                lista.add("500"); // não deve aparecer
                return lista;
            }

            @Override
            public ArrayList<String> getRecursos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("/not-found.html");
                lista.add("/forbidden.html");
                lista.add("/server-error.html");
                return lista;
            }

            @Override
            public ArrayList<String> getDatas() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("12/Nov/2021:14:22:01");
                lista.add("30/Nov/2021:23:59:59");
                lista.add("15/Oct/2021:10:00:00"); // não deve aparecer
                return lista;
            }
        };

        NaoRespondidos relatorio = new NaoRespondidos(mock);
        relatorio.gerarRelatorio(); // saída esperada no arquivo e/ou terminal
    }
}
