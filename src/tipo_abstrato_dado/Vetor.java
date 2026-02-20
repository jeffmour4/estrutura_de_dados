package tipo_abstrato_dado;

import java.util.ArrayList;
import java.util.List;

public class Vetor {

    private int tamanho;
    private int minimo;
    private int maximo;
    private boolean repetido;
    private int[] dados;
    private int vago;

    public boolean getRepetido() {
        return this.repetido;
    }

    public Vetor(int tamanho, int minimo, int maximo, boolean repetido) {
        this.tamanho = tamanho;
        this.minimo = minimo;
        this.maximo = maximo;
        this.repetido = repetido;
        this.dados = new int[this.tamanho];
        this.vago = -1;

        this.dados = new int[tamanho];
        for (int x = 0; x < tamanho; x++) {
            this.dados[x] = this.vago;
        }

    }

    public boolean validaPosicao(int index) {
        boolean result = false;
        if (index >= 0 && index < this.tamanho) {
            result = true;
        }
        return result;
    }

    public boolean validaValor(int valor, boolean repete) {
        boolean result = false;
        if (!repete){
            if(!this.retornaPosicao(valor).isEmpty()) {
                return result;
            }
        }
        if (valor >= this.minimo && valor <= this.maximo) {
            result = true;
        }
        return result;
    }

    public boolean atribuirValor(int index, int valor) {
        boolean result = false;
        if(this.retornaValor(index) == this.vago) {
            this.dados[index] = valor;
            result = true;
        }
        return result;
    }

    public boolean alterarValor(int index, int valor) {
        boolean result = false;
        if(this.retornaValor(index) != this.vago) {
            this.dados[index] = valor;
            result = true;
        }
        return result;
    }

    public int retornaValor(int index) {
        return this.dados[index];
    }

    public boolean excluirValor(int index) {
        boolean result = false;
        if (this.retornaValor(index) != -1) {
            this.dados[index] = this.vago;
            result = true;
        }
        return result;
    }

    public List<Integer> retornaPosicao(int valor) {
        List<Integer> arrayPosicao = new ArrayList<>();
        for (int x = 0; x < this.tamanho; x++) {
            if (this.dados[x] == valor) {
                arrayPosicao.add(x);
                if (!this.repetido) {
                    break;
                }
            }
        }
        return arrayPosicao;
    }

    public boolean inserirPrimeiraVaga(int valor) {
        boolean result = false;
        for (int x = 0; x < this.tamanho; x++) {
            if (this.dados[x] == this.vago) {
                this.dados[x] = valor;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean removerUltimoElemento() {
        boolean result = false;
        for (int x = tamanho-1; x >= 0; x--) {
            if (this.dados[x] != this.vago) {
                this.dados[x] = this.vago;
                result = true;
                break;
            }
        }
        return result;
    }

    public String imprimirVetor() {
        String vetorImpresso = "";
        for (int x = 0; x < tamanho; x++) {
            if (this.dados[x] == this.vago) {
                vetorImpresso = vetorImpresso.concat("_").concat(", ");
            } else {
                vetorImpresso = vetorImpresso.concat(Integer.toString(this.dados[x])).concat(", ");
            }
        }
        return vetorImpresso;
    }




}
