package br.upe.analisandoLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TratadorArquivo {
    private ArrayList<String> ips = new ArrayList<>();
    private ArrayList<String> datas = new ArrayList<>();
    private ArrayList<String> metodos = new ArrayList<>();
    private ArrayList<String> recursos = new ArrayList<>();
    private ArrayList<String> statusCodes = new ArrayList<>();
    private ArrayList<String> tamanhos = new ArrayList<>();
    private ArrayList<String> userAgents = new ArrayList<>();

    public TratadorArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                tratarLinha(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void tratarLinha(String linha) {
        try {
            // IP
            String ip = linha.split(" ")[0];
            ips.add(ip);

            // Data
            int iniData = linha.indexOf("[") + 1;
            int fimData = linha.indexOf("]");
            String data = linha.substring(iniData, fimData);
            datas.add(data);

            // Método e recurso
            int iniMetodo = linha.indexOf("\"") + 1;
            int fimMetodo = linha.indexOf("\"", iniMetodo);
            String[] metodoErecurso = linha.substring(iniMetodo, fimMetodo).split(" ");
            String metodo = metodoErecurso.length > 0 ? metodoErecurso[0] : "-";
            String recurso = metodoErecurso.length > 1 ? metodoErecurso[1] : "-";
            metodos.add(metodo);
            recursos.add(recurso);

            // Status code e tamanho
            String[] partes = linha.substring(fimMetodo + 2).split(" ");
            String status = partes.length > 0 ? partes[0] : "-";
            String tamanho = partes.length > 1 ? partes[1] : "-";
            statusCodes.add(status);
            tamanhos.add(tamanho);

            // User Agent
            int firstQuote = linha.indexOf("\"", fimMetodo + 1);
            int secondQuote = linha.indexOf("\"", firstQuote + 1);
            int thirdQuote = linha.indexOf("\"", secondQuote + 1);
            int fourthQuote = linha.indexOf("\"", thirdQuote + 1);
            String userAgent = (thirdQuote != -1 && fourthQuote != -1) ? linha.substring(thirdQuote + 1, fourthQuote) : "-";
            userAgents.add(userAgent);
        } catch (Exception e) {
            // Em caso de erro inesperado, adicione "-" para manter alinhamento
            ips.add("-");
            datas.add("-");
            metodos.add("-");
            recursos.add("-");
            statusCodes.add("-");
            tamanhos.add("-");
            userAgents.add("-");
        }
    }

    // Getters
    public ArrayList<String> getIps() {
        return ips;
    }

    public int getNumeroLinhas() {
        return ips.size();
    }

    public ArrayList<String> getTamanhos() {
        return tamanhos;
    }

    public ArrayList<String> getCodigos(){
        return statusCodes;
    }

    public ArrayList<String> getMetodos() {
        return metodos;
    }
    
    public ArrayList<String> getDatas() {
        return datas;
    }
}
