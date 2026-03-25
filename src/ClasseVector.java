import tipos.Quadrado;

import java.util.Scanner;
import java.util.Vector;

public class ClasseVector {
    static Vector<Quadrado> vetor;

    void main() {
        Scanner scanner = new Scanner(System.in);

        IO.println("Capacidade inicial do vetor: ");
        int capacidadeInicial = scanner.nextInt();
        if (capacidadeInicial <= 0) {
            IO.println("Capacidade inválida!");
        }
        vetor = new Vector<>(capacidadeInicial);

        while (true) {
            IO.println("--------CLASSE VECTOR---------");
            IO.println("------------------------------");
            IO.println("0 - encerrar");
            IO.println("1 - capacidade do vetor");
            IO.println("2 - número de elementos do vetor");
            IO.println("3 - Inserir novo elemento no final do vetor");
            IO.println("4 - inserir novo elemento em um índice específico");
            IO.println("5 - atribuir novo elemento a uma posição específica");
            IO.println("6 - localizar um elemento");
            IO.println("7 - remover um elemento dado o índice");
            IO.println("8 - remover um elemento dado um elemento");
            IO.println("9 - imprimir os elementos do vetor");
            IO.println("--------------------------------");
            IO.println("Opção: ");

            byte opcao = scanner.nextByte();
            float tamanhoLinha;
            int posicao = -1;
            Quadrado quadrado;

            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                IO.println(vetor.capacity());
            } else if (opcao == 2) {
                if (vetor.isEmpty()) {
                    IO.println("Vetor vazio!");
                } else {
                    IO.println(vetor.size());
                }
            } else if (opcao == 3) {
                IO.println("Digite o tamanho da linha do quadrado em centímetros: ");
                tamanhoLinha = scanner.nextFloat();
                quadrado = new Quadrado(tamanhoLinha);
                vetor.add(quadrado);
            } else if (opcao == 4) {
                if (vetor.size() >= vetor.capacity() ) {
                    IO.println("Vetor cheio!");
                } else {
                    IO.print("Digite a posição: ");
                    posicao = scanner.nextInt();
                    if (posicao > vetor.size() - 1 || posicao < 0) {
                        IO.println("Posição inválida!");
                    } else {
                        IO.println("Digite o tamanho da linha do quadrado em centímetros: ");
                        tamanhoLinha = scanner.nextFloat();
                        quadrado = new Quadrado(tamanhoLinha);
                        vetor.add(posicao, quadrado);
                    }
                }
            } else if (opcao == 5) {
                IO.println("Digite a posição: ");
                posicao = scanner.nextInt();
                if (vetor.elementAt(posicao).getClass() != Quadrado.class) {
                    IO.println("Posição inválida");
                } else {
                    IO.println("Digite o tamanho da linha do quadrado em centímetros: ");
                    tamanhoLinha = scanner.nextFloat();
                    quadrado = new Quadrado(tamanhoLinha);
                    vetor.set(posicao, quadrado);
                }
            } else if (opcao == 6) {
                IO.println("Digite o tamanho do lado do quadrado que deseja localizar: ");
                tamanhoLinha = scanner.nextFloat();
                for (int x = 0; x < vetor.capacity(); x++) {
                    if (vetor.elementAt(x).getLado() == tamanhoLinha) {
                        posicao = x;
                        break;
                    }
                }
                if (posicao != -1) {
                    IO.println("O elemento está na posição: "+posicao);
                } else {
                    IO.println("Elemento não encontrado!");
                }
            } else if (opcao == 7) {
                IO.println("Digite a posição do elemento a ser removido: ");
                posicao = scanner.nextInt();
                try {
                    vetor.remove(posicao);
                } catch (Exception e) {
                    IO.println("Elemento não encontrado!");
                }
            } else if (opcao == 8) {
                IO.println("Digite o tamanho do lado do quadrado a ser removido: ");
                tamanhoLinha = scanner.nextFloat();
                boolean removido = false;
                for (int x = 0; x < vetor.size(); x++) {
                    if (vetor.elementAt(x).getLado() == tamanhoLinha) {
                        vetor.remove(x);
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    IO.println("Elemento não encontrado!");
                }
            } else if (opcao == 9) {
                String vetorImpresso = "";
                for (int x = 0; x < vetor.capacity(); x++) {
                    try {
                        vetorImpresso += vetor.elementAt(x).getLado() + ", ";
                    } catch (Exception e) {
                        vetorImpresso += "_, ";
                    }
                }
                IO.println(vetorImpresso);
            }


        }

    }
}
