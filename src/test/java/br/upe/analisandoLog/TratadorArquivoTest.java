package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TratadorArquivoTest {
    @Test
    public void testParsingSingleLogLine() throws IOException {
        String logLine = "192.168.0.1 - - [12/Dec/2021:10:10:10 +0000] \"POST /api/data HTTP/1.1\" 200 1234 \"-\" \"TestAgent/1.0\"";
        String filePath = "access.log";
        FileWriter writer = new FileWriter(filePath);
        writer.write(logLine);
        writer.close();

        TratadorArquivo tratador = new TratadorArquivo(filePath);
        assertEquals(1, tratador.getNumeroLinhas());
        assertEquals("POST", tratador.getMetodos().get(0));
        assertEquals("200", tratador.getCodigos().get(0));
        assertEquals("1234", tratador.getTamanhos().get(0));
    }
}
