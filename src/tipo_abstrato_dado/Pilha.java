package tipo_abstrato_dado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Pilha {

    private int tamanho;
    private int[] pilha;
    private boolean repetido;

    public Pilha (int tamanho, boolean repetido) {
        this.tamanho = tamanho;
        this.pilha = new int[tamanho];
        this.repetido = repetido;

        /*for (int x = 0; x < tamanho; x++) {
            this.pilha[x] = -1;
        }*/
    }

    public boolean inserirElemento(int elemento) {
        boolean result = false;
        if (!this.repetido) {
            if (!this.retornarPosicao(elemento).isEmpty()) {
                return result;
            }
        }

        for (int x = 0; x < this.tamanho; x++) {
            if (this.pilha[x] == 0/*IntStream.of(this.pilha[x]).equals(IntStream.empty())*/  /*== -1*/) {
                this.pilha[x] = elemento;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean removerElemento() {
        boolean result = false;
        for (int x = this.tamanho -1; x >= 0; x--) {
            if (this.pilha[x] != 0) {
                this.pilha[x] = 0;
                result = true;
                break;
            }
        }
        return result;
    }

    public String imprimirPilha() {
        String pilha = "";
        for( int elemento: this.pilha) {
            if (elemento != 0/*!IntStream.of(elemento).equals(IntStream.empty())*//*elemento != -1*/) {
                pilha += elemento + ", ";
            } else {
                pilha += "_, ";
            }
        }
        return pilha;
    }

    public int quantidadeElementos() {
        int quantidade = 0;
        for (int elemento: this.pilha) {
            if (elemento != 0) {
                quantidade += 1;
            }
        }
        return quantidade;
    }

    public int[] posicaoTopo() {
        int[] posicao = new int[2];
        /*if (this.pilha[0] == 0) {
            return posicao;
        } else {*/
            for (int x = 0; x < this.tamanho; x++) {
                if(this.pilha[x] != 0) {
                    posicao[0] = x;
                    posicao[1] = this.pilha[x];
                }
            }
        //}
        return posicao;
    }

    public List<Integer> retornarPosicao(int valor) {
        List<Integer> arrayPosicao = new ArrayList<>();
        for (int x = 0; x < this.tamanho; x++) {
            if (this.pilha[x] == valor) {
                arrayPosicao.add(x);
                if (!this.repetido) {
                    break;
                }
            }
        }
        return arrayPosicao;
    }


}
