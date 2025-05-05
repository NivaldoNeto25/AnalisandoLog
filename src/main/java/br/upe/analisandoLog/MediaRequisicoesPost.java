package br.upe.analisandoLog;

import java.util.ArrayList;

public class MediaRequisicoesPost {
    private TratadorArquivo tratador;

    public MediaRequisicoesPost(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void exibirMedia() {
        ArrayList<EntradaLog> entradas = tratador.getEntradas();

        double soma = 0;
        int contagem = 0;

        for (EntradaLog entrada : entradas) {
            String metodo = entrada.getMetodo();
            String statusStr = entrada.getStatusCode();
            String data = entrada.getData();
            String tamanhoStr = entrada.getTamanho();

            if (metodo.equals("POST") && statusStr.matches("\\d{3}")) {
                try {
                    int status = Integer.parseInt(statusStr);
                    if (status >= 200 && status <= 299 && data.contains("/2021:") && !tamanhoStr.equals("-")) {
                        soma += Integer.parseInt(tamanhoStr);
                        contagem++;
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }

        if (contagem > 0) {
            double media = soma / contagem;
            System.out.printf("Média dos tamanhos das requisições POST com sucesso em 2021: %.2f bytes%n", media);
        } else {
            System.out.println("Nenhuma requisição POST bem-sucedida encontrada para 2021.");
        }
    }
}