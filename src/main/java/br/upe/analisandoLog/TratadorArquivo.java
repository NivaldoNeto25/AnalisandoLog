package br.upe.analisandoLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String regex = "^(\\S+) - - \\[([^\\]]+)] \"(\\S+) (.*?) (\\S+)\" (\\d{3}) (\\d+|-) \"[^\"]*\" \"([^\"]*)\"";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(linha);

            if (matcher.find()) {
                String ip = matcher.group(1);
                String data = matcher.group(2);
                String metodo = matcher.group(3);
                String recurso = matcher.group(4);
                String statusCode = matcher.group(6);
                String tamanho = matcher.group(7);
                String userAgent = matcher.group(8);

                EntradaLog entrada = new EntradaLog(ip, data, metodo, recurso, statusCode, tamanho, userAgent);
                entradas.add(entrada);
            } else {
                entradas.add(new EntradaLog("-", "-", "-", "-", "-", "-", "-"));
            }
        } catch (Exception e) {
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

