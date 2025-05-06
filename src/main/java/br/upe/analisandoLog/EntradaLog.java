package br.upe.analisandoLog;

public class EntradaLog {
    private String ip;
    private String data;
    private String metodo;
    private String recurso;
    private String statusCode;
    private String tamanho;
    private String userAgent;

    public EntradaLog(String ip, String data, String metodo, String recurso, String statusCode, String tamanho, String userAgent) {
        this.ip = ip;
        this.data = data;
        this.metodo = metodo;
        this.recurso = recurso;
        this.statusCode = statusCode;
        this.tamanho = tamanho;
        this.userAgent = userAgent;
    }

    // Getters
    public String getIp() {
        return ip;
    }

    public String getData() {
        return data;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getUserAgent() {
        return userAgent;
    }
}