import tipo_abstrato_dado.QuebraCabecaPilha;

void main() {
    IO.println("_______________________________-------_______________________________");
    IO.println("--------------Jogo de organização de números em pilhas---------------");
    IO.println("Coloque os números menores em uma pilha e os números maiores em outra");
    IO.println("---------------------------------------------------------------------");
    QuebraCabecaPilha pilha = new QuebraCabecaPilha(10, 1, 100);
    while (true) {
        int tamanho = pilha.getTamanho();
        int[] pilha1 = pilha.getPilha1();
        int[] pilha2 = pilha.getPilha2();
        int[] pilha3 = pilha.getPilha3();
        IO.println("Pilha 1 -- Pilha 2 -- Pilha3");
        /*for(int x = 0; x < tamanho; x++) {
            String slot1 = pilha1[x]<10?" "+pilha1[x]:Integer.toString(pilha1[x]);
            String slot2 = pilha2[x]<10?" "+pilha2[x]:Integer.toString(pilha2[x]);
            String slot3 = pilha3[x]<10?" "+pilha3[x]:Integer.toString(pilha3[x]);
            IO.println("  " + slot1 + "         " + slot2 + "         " + slot3);
        }*/
        pilha.imprimirPilhas();
        if (pilha.verificaFimDeJogo()) {
            IO.println("Fim de jogo! Parabens!");
            break;
        } else {
            IO.println("0 - Encerrar");
            IO.println("1 - Mover da pilha 1 para a 2");
            IO.println("2 - Mover da pilha 1 para a 3");
            IO.println("3 - Mover da pilha 2 para a 1");
            IO.println("4 - Mover da pilha 2 para a 3");
            IO.println("5 - Mover da pilha 3 para a 1");
            IO.println("6 - Mover da pilha 3 para a 2");
            IO.println("Digite a opção: ");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                if (!pilha.moverPilha1para2()) {
                    IO.println("Movimento inválido!");
                }
            } else if (opcao == 2) {
                if (!pilha.moverPilha1para3()) {
                    IO.println("Movimento inválido!");
                }
            } else if (opcao == 3) {
                if (!pilha.moverPilha2para1()) {
                    IO.println("Movimento inválido!");
                }
            } else if (opcao == 4) {
                if (!pilha.moverPilha2para3()) {
                    IO.println("Movimento inválido!");
                }
            } else if (opcao == 5) {
                if (!pilha.moverPilha3para1()) {
                    IO.println("Movimento inválido!");
                }
            } else if (opcao == 6) {
                if (!pilha.moverPilha3para2()) {
                    IO.println("Movimento inválido!");
                }
            }
        }

    }
}
