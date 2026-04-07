package tipo_abstrato_dado;

import java.util.ArrayList;

public class FilaArray {

    int tamanho;
    int inicio;
    int fim;
    float[] fila;
    String ultimaOperacao;

    public FilaArray(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new float[tamanho];
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean addElement(float elemento) {
        boolean result = false;
        if (!this.statusFila().equals("cheia")) {
            for (int x = 0; x < this.tamanho; x++) {
                if (this.fila[x] == 0 && this.fim == x) {
                    this.fila[this.fim] = elemento;
                    this.fim ++;
                    if (this.fim == this.tamanho) {
                        this.fim = 0;
                    }
                    this.ultimaOperacao = "entrada";
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean removeElement() {
        boolean result = false;
        if (!this.statusFila().equals("vazia")) {
            for (int x = 0; x < this.tamanho; x++) {
                if (this.fila[x] != 0 && this.inicio == x) {
                    this.fila[x] = 0f;
                    this.inicio = x + 1;
                    if (this.inicio == this.tamanho) {
                        this.inicio = 0;
                    }
                    this.ultimaOperacao = "saida";
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public String imprimirFila() {
        String filaImpressa = "";
        for (int x = this.inicio; x < this.tamanho; x++) {
            if (this.fila[x] != 0) {
                filaImpressa = filaImpressa.concat(Float.toString(this.fila[x])).concat(", ");
            }
        }
        for (int x = 0; x < this.inicio; x++) {
            if (this.fila[x] != 0) {
                filaImpressa = filaImpressa.concat(Float.toString(this.fila[x])).concat(", ");
            }
        }
        return filaImpressa;
    }

    public String statusFila() {
        try {
            if (this.ultimaOperacao.equals("entrada") && this.fim == this.inicio /*this.fim - this.inicio >= this.tamanho*/) {
                return "cheia";
            } else if (this.ultimaOperacao.equals("saida") && this.fim == 0 && this.inicio == 0) {
                return "vazia";
            } else {
                return "tem vaga";
            }
        } catch (Exception e) {
            return "vazia";
        }
    }

    public String informacoesFila() {
         return String.format("Capacidade da fila: %d. Início: %d. Fim: %d. Status: %s. Última operação: %s", this.tamanho, this.inicio, this.fim, this.statusFila(), this.ultimaOperacao);
    }

}
