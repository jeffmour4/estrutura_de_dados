package tipo_abstrato_dado;

import java.util.ArrayList;
import java.util.Vector;

public class Fila {

    int tamanho;
    int inicio;
    int fim;
    ArrayList<Float> fila;
    String ultimaOperacao;

    public Fila(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new ArrayList<>();
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean addElement(float elemento) {
        boolean result = false;
        if (!this.statusFila().equals("cheia")) {
            this.fila.add(elemento);
            this.fim ++;
            this.ultimaOperacao = "entrada";
            result = true;
        }
        return result;
    }

    public boolean removeElement() {
        boolean result = false;
        if (!this.statusFila().equals("vazia")) {
            for (int x = 0; x < this.fila.size(); x++) {
                if (this.fila.get(x) != 0) {
                    this.fila.set(x, 0f);
                    this.inicio = x + 1;
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
        for (float v : this.fila) {
            if (v != 0) {
                filaImpressa = filaImpressa.concat(Float.toString(v)).concat(", ");
            }
        }
        return filaImpressa;
    }

    public String statusFila() {
        try {
            if (this.ultimaOperacao.equals("entrada") && this.fim - this.inicio >= this.tamanho) {
                return "cheia";
            } else if (this.ultimaOperacao.equals("saida") && this.fim == this.inicio) {
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
