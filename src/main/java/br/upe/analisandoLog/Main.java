package br.upe.analisandoLog;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Caminho absoluto do arquivo access.log
        String caminhoAbsoluto = Paths.get("access.log").toAbsolutePath().toString();

        System.out.println("=== Analisador de Logs ===");

        // Criação do objeto TratadorArquivo
        TratadorArquivo tratador = new TratadorArquivo(caminhoAbsoluto);

        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Recursos grandes respondidos\n2 - Não respondidos\n3 - % de requisições por SO\n4 - Média das requisições POST\n0 - Sair");
            System.out.print("Opção: ");
            
            try {
                int opcao = Integer.parseInt(scanner.nextLine());  // Lê a entrada como String e converte para int
                
                switch (opcao) {
                    case 1:
                        RecursosGrandesRespondidos recursos = new RecursosGrandesRespondidos(tratador);
                        recursos.gerarRelatorio();
                        break;
                    case 2:
                        // Chama a função para a opção 2
                        break;
                    case 3:
                        // Chama a função para a opção 3
                        break;
                    case 4:
                        MediaRequisicoesPost media = new MediaRequisicoesPost(tratador);
                        media.exibirMedia();
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número entre 0 e 4.");
            }
        }