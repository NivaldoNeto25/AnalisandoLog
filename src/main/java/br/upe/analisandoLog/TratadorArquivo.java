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
        
            br.readLine();
            
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
    	String regex = "^(\\S+) - - \\[([^\\]]+)] \"(\\S+) (.*?) (\\S+)\" (\\d{3}) (\\d+|-) \"[^\"]*\" \"([^\"]*)\"";
    	
    	try {
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(linha);
            
            if (matcher.find()) {
                ips.add(matcher.group(1));
                datas.add(matcher.group(2));
                metodos.add(matcher.group(3));
                recursos.add(matcher.group(4));
                statusCodes.add(matcher.group(6));
                tamanhos.add(matcher.group(7));
                userAgents.add(matcher.group(8));
            } else {
            adicionarCamposVazios();
        }
        } catch (Exception e) {
            adicionarCamposVazios();
        }
    }

    private void adicionarCamposVazios() {
        ips.add("-");
        datas.add("-");
        metodos.add("-");
        recursos.add("-");
        statusCodes.add("-");
        tamanhos.add("-");
        userAgents.add("-");
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

    public ArrayList<String> getRecursos() {
        return recursos;
    }

    public ArrayList<String> getUserAgents(){
        return userAgents;
    }
}
