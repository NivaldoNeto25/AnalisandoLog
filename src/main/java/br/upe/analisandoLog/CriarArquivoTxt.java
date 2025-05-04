package br.upe.analisandoLog;

import java.io.FileWriter;
import java.io.IOException;

public class CriarArquivoTxt {

    public static void salvar(String nomeArquivo, String conteudo) {
        try {
            String caminho = "analise/" + nomeArquivo;

            FileWriter writer = new FileWriter(caminho);

            writer.write(conteudo);

            writer.close();

            System.out.println("Arquivo '" + nomeArquivo + "' criado com sucesso em /analise.");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}