package br.upe.analisandoLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TratadorArquivo {
    private ArrayList<EntradaLog> entradas = new ArrayList<>();

    public TratadorArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); // Ignora a primeira linha (header), se houver

            String linha;
            while ((linha = br.readLine()) != null) {
                tratarLinha(linha);
            }
            System.out.println("Arquivo carregado com sucesso!");
            System.out.println("Número total de linhas: " + getNumeroLinhas());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void tratarLinha(String linha) {
        try {
            // IP
            String ip = linha.split(" ")[0];

            // Data
            int iniData = linha.indexOf("[") + 1;
            int fimData = linha.indexOf("]");
            String data = linha.substring(iniData, fimData);

            // Metodo e recurso
            int iniMetodo = linha.indexOf("\"") + 1;
            int fimMetodo = linha.indexOf("\"", iniMetodo);
            String[] metodoErecurso = linha.substring(iniMetodo, fimMetodo).split(" ");
            String metodo = metodoErecurso.length > 0 ? metodoErecurso[0] : "-";
            String recurso = metodoErecurso.length > 1 ? metodoErecurso[1] : "-";

            // Código de status e tamanho
            String[] partes = linha.substring(fimMetodo + 2).split(" ");
            String statusCode = partes.length > 0 ? partes[0] : "-";
            String tamanho = partes.length > 1 ? partes[1] : "-";

            // User Agent
            int firstQuote = linha.indexOf("\"", fimMetodo + 1);
            int secondQuote = linha.indexOf("\"", firstQuote + 1);
            int thirdQuote = linha.indexOf("\"", secondQuote + 1);
            int fourthQuote = linha.indexOf("\"", thirdQuote + 1);
            String userAgent = (thirdQuote != -1 && fourthQuote != -1) ?
                    linha.substring(thirdQuote + 1, fourthQuote) : "-";

            // Criar objeto EntradaLog e adicionar na lista
            EntradaLog entrada = new EntradaLog(ip, data, metodo, recurso, statusCode, tamanho, userAgent);
            entradas.add(entrada);
        } catch (Exception e) {
            // Em caso de erro inesperado, adiciona uma entrada com valores default
            entradas.add(new EntradaLog("-", "-", "-", "-", "-", "-", "-"));
        }
    }

    public ArrayList<EntradaLog> getEntradas() {
        return entradas;
    }

    public int getNumeroLinhas() {
        return entradas.size();
    }
}