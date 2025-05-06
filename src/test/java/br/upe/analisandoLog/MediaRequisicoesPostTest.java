package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;



public class MediaRequisicoesPostTest {
    @Test
    public void testMediaCalculadaCorretamente() {
        TratadorArquivo mock = new TratadorArquivo("test.txt") {
            @Override
            public ArrayList<String> getMetodos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("POST");
                return lista;
            }

            @Override
            public ArrayList<String> getCodigos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("200");
                return lista;
            }

            @Override
            public ArrayList<String> getDatas() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("12/Dec/2021:10:10:10");
                return lista;
            }

            @Override
            public ArrayList<String> getTamanhos() {
                ArrayList<String> lista = new ArrayList<>();
                lista.add("5000");
                return lista;
            }

            @Override
            public int getNumeroLinhas() {
                return 1;
            }
        };

        MediaRequisicoesPost media = new MediaRequisicoesPost(mock);
        media.exibirMedia(); // Verificação visual
    }
}
