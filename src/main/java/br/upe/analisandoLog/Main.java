package br.upe.analisandoLog;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Monta o caminho absoluto do arquivo acesso.log de forma portável
        String caminhoAbsoluto = Paths.get("access.log").toAbsolutePath().toString();

        TratadorArquivo tratador = new TratadorArquivo(caminhoAbsoluto);

        System.out.println("=== Analisador de Logs ===");
        System.out.println("Arquivo carregado com sucesso!");
        System.out.println("Número total de linhas: " + tratador.getNumeroLinhas());

        // Exemplo de exibição de IPs
        System.out.println("\nExemplo de IPs lidos:");
        for (int i = 0; i < 5 && i < tratador.getIps().size(); i++) {
            System.out.println(tratador.getIps().get(i));
        }

        scanner.close();
    }
}

