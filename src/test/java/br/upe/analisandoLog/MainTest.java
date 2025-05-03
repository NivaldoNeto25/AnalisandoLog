package br.upe.analisandoLog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testMainExecutesWithoutCrash() {
        // Teste básico apenas para verificar se o método main é invocável
        try {
            String[] args = {};
            Main.main(args);
        } catch (Exception e) {
            fail("Main method should not throw exception: " + e.getMessage());
        }
    }
}
