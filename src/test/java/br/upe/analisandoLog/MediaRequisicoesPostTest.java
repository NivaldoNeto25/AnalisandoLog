package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MediaRequisicoesPostTest {

    @Test
    public void testMediaCalculadaCorretamente() {
        TratadorArquivo mock = new TratadorArquivo("teste.txt") {
            @Override
            public ArrayList<EntradaLog> getEntradas() {
                List<EntradaLog> entradas = new ArrayList<>();
                entradas.add(new EntradaLog("127.0.0.1", "10/Nov/2021", "POST", "/recurso", "200", "6000", "Mozilla"));
                entradas.add(new EntradaLog("127.0.0.1", "10/Nov/2021", "POST", "/recurso2", "200", "4000", "Mozilla"));
                return entradas;
            }
        };

        MediaRequisicoesPost media = new MediaRequisicoesPost(mock);
        media.exibirMedia();
    }
}

