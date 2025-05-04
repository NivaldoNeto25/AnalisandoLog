package br.upe.analisandoLog;

import java.util.ArrayList;

public class MediaRequisicoesPost {
    private TratadorArquivo tratador;

    public MediaRequisicoesPost(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public void exibirMedia() {
        ArrayList<String> metodos = tratador.getMetodos();
        ArrayList<String> statusCodes = tratador.getCodigos();
        ArrayList<String> datas = tratador.getDatas();
        ArrayList<String> tamanhos = tratador.getTamanhos();
    
        int linhasValidas = Math.min(
            Math.min(metodos.size(), statusCodes.size()),
            Math.min(datas.size(), tamanhos.size())
        );
    
        double soma = 0;
        int contagem = 0;
    
        for (int i = 0; i < linhasValidas; i++) {
            String metodo = metodos.get(i);
            String statusStr = statusCodes.get(i);
            String data = datas.get(i);
            String tamanhoStr = tamanhos.get(i);
    
            if (metodo.equals("POST") &&
                statusStr.matches("\\d{3}") &&
                Integer.parseInt(statusStr) >= 200 &&
                Integer.parseInt(statusStr) <= 299 &&
                data.contains("/2021:") &&
                !tamanhoStr.equals("-")) {
    
                try {
                    soma += Integer.parseInt(tamanhoStr);
                    contagem++;
                } catch (NumberFormatException ignored) {}
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