package tipo_abstrato_dado;

import java.util.Random;

public class QuebraCabecaPilha {

    private int tamanho;
    private int min;
    private int max;
    private int[] pilha1;
    private int[] pilha2;
    private int[] pilha3;

    public QuebraCabecaPilha(int tamanho, int min, int max) {
        this.tamanho = tamanho;
        this.min = min;
        this.max = max;
        this.pilha1 = new int[tamanho];
        this.pilha2 = new int[tamanho];
        this.pilha3 = new int[tamanho];

        Random randon = new Random();
        for (int x = tamanho -1; x >= 5; x--) {
            this.pilha1[x] = randon.nextInt(this.max - this.min);
            this.pilha2[x] = randon.nextInt(this.max - this.min);
            for (int z = 0; z < 10; z++) {
                for(int y = 0; y < tamanho; y++) {
                    if (this.pilha1[x] == this.pilha1[y]) {
                        this.pilha1[x] = randon.nextInt(this.max - this.min);
                    }
                    if (this.pilha2[x] == this.pilha2[y]) {
                        this.pilha2[x] = randon.nextInt(this.max - this.min);
                    }
                    if (this.pilha1[x] == this.pilha2[y]) {
                        this.pilha1[x] = randon.nextInt(this.max - this.min);
                    }
                    if (this.pilha2[x] == this.pilha1[y]) {
                        this.pilha2[x] = randon.nextInt(this.max - this.min);
                    }
                }
            }
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }
    public int[] getPilha1() {
        return this.pilha1;
    }
    public int[] getPilha2() {
        return this.pilha2;
    }
    public int[] getPilha3() {
        return this.pilha3;
    }
    public void imprimirPilhas() {
        for(int x = 0; x < this.tamanho; x++) {
            String slot1 = this.pilha1[x]<10?" "+this.pilha1[x]:Integer.toString(this.pilha1[x]);
            String slot2 = this.pilha2[x]<10?" "+this.pilha2[x]:Integer.toString(this.pilha2[x]);
            String slot3 = this.pilha3[x]<10?" "+this.pilha3[x]:Integer.toString(this.pilha3[x]);
            IO.println("  " + slot1 + "         " + slot2 + "         " + slot3);
        }
    }
    public boolean moverPilha1para2() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha1[x] != 0) {
                item1 = this.pilha1[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha2[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha2[x] != 0) {
                item2 = this.pilha2[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha2[slot2] == 0) {
                this.pilha1[slot1] = 0;
                this.pilha2[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha2[slot2] == 0) {
                this.pilha1[slot1] = 0;
                this.pilha2[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean moverPilha1para3() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha1[x] != 0) {
                item1 = this.pilha1[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha3[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha3[x] != 0) {
                item2 = this.pilha3[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha3[slot2] == 0) {
                this.pilha1[slot1] = 0;
                this.pilha3[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha3[slot2] == 0) {
                this.pilha1[slot1] = 0;
                this.pilha3[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean moverPilha2para1() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha2[x] != 0) {
                item1 = this.pilha2[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha1[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha1[x] != 0) {
                item2 = this.pilha1[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha1[slot2] == 0) {
                this.pilha2[slot1] = 0;
                this.pilha1[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha1[slot2] == 0) {
                this.pilha2[slot1] = 0;
                this.pilha1[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean moverPilha2para3() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha2[x] != 0) {
                item1 = this.pilha2[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha3[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha3[x] != 0) {
                item2 = this.pilha3[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha3[slot2] == 0) {
                this.pilha2[slot1] = 0;
                this.pilha3[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha3[slot2] == 0) {
                this.pilha2[slot1] = 0;
                this.pilha3[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean moverPilha3para1() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha3[x] != 0) {
                item1 = this.pilha3[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha1[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha1[x] != 0) {
                item2 = this.pilha1[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha1[slot2] == 0) {
                this.pilha3[slot1] = 0;
                this.pilha1[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha1[slot2] == 0) {
                this.pilha3[slot1] = 0;
                this.pilha1[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean moverPilha3para2() {
        boolean result = false;
        int item1 = 0;
        int item2 = 0;
        int slot1 = -1;
        int slot2 = -1;
        for(int x = 0; x < tamanho; x++) {
            if (this.pilha3[x] != 0) {
                item1 = this.pilha3[x];
                slot1 = x;
                break;
            }
        }
        for(int x = tamanho -1; x >= 0; x--) {
            if (this.pilha2[x] == 0) {
                slot2 = x;
                break;
            }
            if (this.pilha2[x] != 0) {
                item2 = this.pilha2[x];
            }
        }
        if (item2 > 0) {
            if (item1 < item2 && slot1 >= 0 && slot2 >= 0 && this.pilha2[slot2] == 0) {
                this.pilha3[slot1] = 0;
                this.pilha2[slot2] = item1;
                result = true;
            }
        } else if (item2 == 0) {
            if (slot1 >= 0 && slot2 >= 0 && this.pilha2[slot2] == 0) {
                this.pilha3[slot1] = 0;
                this.pilha2[slot2] = item1;
                result = true;
            }
        }
        return result;
    }
    public boolean verificaFimDeJogo() {
        boolean validacao = true;
        boolean validacao1 = true;
        boolean validacao2 = true;
        boolean validacao3 = true;
        boolean result = false;

        for (int x = tamanho -1; x > 0; x--) {
            if (this.pilha1[x] >= this.pilha1[x-1]) {
                validacao1 = false;
            }
            if (this.pilha2[x] >= this.pilha2[x-1]) {
                validacao2 = false;
            }
            if (x < 5) {
                if (this.pilha1[x] != 0) {
                    validacao1 = false;
                }
                if (this.pilha1[x-1] != 0) {
                    validacao1 = false;
                }
                if (this.pilha2[x] != 0) {
                    validacao2 = false;
                }
                if (this.pilha2[x-1] != 0) {
                    validacao2 = false;
                }
            }
            if (this.pilha3[x] != 0) {
                validacao3 = false;
            }
            if (this.pilha3[x-1] != 0) {
                validacao3 = false;
            }

        }
        if (this.pilha1[tamanho-1] > this.pilha2[tamanho/2+1]) {
            validacao = false;
        }

        if (validacao && validacao1 && validacao2 && validacao3) {
            result = true;
        }
        return result;
    }
}
