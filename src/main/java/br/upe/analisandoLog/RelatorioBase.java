package br.upe.analisandoLog;

public abstract class RelatorioBase {
    protected TratadorArquivo tratador;

    public RelatorioBase(TratadorArquivo tratador) {
        this.tratador = tratador;
    }

    public abstract void gerarRelatorio();
}