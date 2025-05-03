package br.upe.analisandoLog;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Caminho absoluto do arquivo access.log
        String caminhoAbsoluto = Paths.get("access.log").toAbsolutePath().toString();
        TratadorArquivo tratador = new TratadorArquivo(caminhoAbsoluto);

        System.out.println("=== Analisador de Logs ===");
        System.out.println("Arquivo carregado com sucesso!");
        System.out.println("Número total de linhas: " + tratador.getNumeroLinhas());

        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Gerar relatório de recursos grandes");
            System.out.println("4 - Mostrar média de POSTs com sucesso em 2021");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    RecursosGrandesRespondidos recursos = new RecursosGrandesRespondidos(tratador);
                    recursos.gerarRelatorio();
                    break;
                case "4":
                    MediaRequisicoesPost media = new MediaRequisicoesPost(tratador);
                    media.exibirMedia();
                    break;
                case "0":
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
