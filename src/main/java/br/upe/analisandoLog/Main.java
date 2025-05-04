package br.upe.analisandoLog;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Caminho absoluto do arquivo access.log
        String caminhoAbsoluto = Paths.get("access.log").toAbsolutePath().toString();

        System.out.println("=== Analisador de Logs ===");

        TratadorArquivo tratador = new TratadorArquivo(caminhoAbsoluto);

        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Recursos grandes respondidos\n2 - Não respondidos\n3 - % de requisições por SO\n4 - Média das requisições POST\n0 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    RecursosGrandesRespondidos recursos = new RecursosGrandesRespondidos(tratador);
                    recursos.gerarRelatorio();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
