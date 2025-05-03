package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecursosGrandesRespondidosTest {
    @Test
    public void testRelatorioContemLinhaEsperada() {
        TratadorArquivo mock = new TratadorArquivo("acess.log") {
            @Override
            public ArrayList<String> getCodigos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("200");
                return lista;
            }

            @Override
            public ArrayList<String> getTamanhos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("3000");
                return lista;
            }

            @Override
            public ArrayList<String> getIps() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("127.0.0.1");
                return lista;
            }
        };

        RecursosGrandesRespondidos recursos = new RecursosGrandesRespondidos(mock);
        recursos.gerarRelatorio(); // Verificação visual
    }
}
