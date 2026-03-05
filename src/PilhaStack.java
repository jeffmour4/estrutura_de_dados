package tipo_abstrato_dado;

import tipos.Triangulo;

import java.util.Scanner;
import java.util.Stack;

public class PilhaStack {

    void main() {

        Stack<Integer> stack1 = new Stack();
        Stack<Triangulo> stack2 = new Stack();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            IO.println("********************************************");
            IO.println("Pilha 1 = Contém números inteiros");
            IO.println("Pilha 2 = Contém objetos da classe Triângulo");
            IO.println("____________________________________________");
            IO.println("0 - encerrar");
            IO.println("----Opções da Pilha 1----");
            IO.println("1 - inserir elemento");
            IO.println("2 - extrair elemento");
            IO.println("3 - localizar elemento");
            IO.println("4 - imprimir a pilha");
            IO.println("----Opções da Pilha 2----");
            IO.println("5 - inserir triângulo");
            IO.println("6 - extrair triângulo");
            IO.println("7 - localizar triângulo");
            IO.println("8 - imprimir a pilha");
            IO.println("____________________________________________");
            IO.println("Digite a opção: ");
            int opcao = scanner.nextByte();

            int elemento;
            float perimetro;
            int valor = 0;
            int posicao = -1;
            float lado1;
            float lado2;
            float lado3;
            Triangulo triangulo = new Triangulo();
            String mensagemElemento = "Digite o elemento: ";
            String mensagemPosicao = "Digite a posição: ";
            //String mensagemErro = "Ocorreu um erro!";

            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                IO.println(mensagemElemento);
                elemento = scanner.nextInt();
                try {
                    valor = stack1.push(elemento);
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
                IO.println("Valor inserido foi: " + valor);
            } else if (opcao == 2) {
                try {
                    valor = stack1.pop();
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
                IO.println("O valor extraído foi: " + valor);
            } else if (opcao == 3) {
                IO.println(mensagemElemento);
                elemento = scanner.nextInt();
                try {
                    posicao = stack1.indexOf(elemento);
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
                if (posicao >= 0) {
                    IO.println("Elemento " + elemento + " tem posição " + posicao);
                } else {
                    IO.println("Elemento não encontrado!");
                }
            } else if (opcao == 4) {
                IO.println(stack1.toString());
            } else if (opcao == 5) {
                try {
                    IO.println("Insira os três lados do triângulo, um por vez: ");
                    lado1 = scanner.nextInt();
                    lado2 = scanner.nextInt();
                    lado3 = scanner.nextInt();
                    triangulo = new Triangulo(lado1, lado2, lado3);
                    if (triangulo.trianguloValido()) {
                        stack2.push(triangulo);
                    } else {
                        IO.println("O triângulo não é válido!");
                    }
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
            } else if (opcao == 6) {
                try {
                    triangulo = stack2.pop();
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
                IO.println("O triângulo extraído tem lados: " + triangulo.getLado1() + " " + triangulo.getLado2() + " " + triangulo.getLado3());
            } else if (opcao == 7) {
                IO.println("Digite o perímetro do triângulo:");
                perimetro = scanner.nextFloat();
                try {
                    for (int x = 0; x < stack2.size(); x++) {
                        if (stack2.get(x).perimetro() == perimetro) {
                            triangulo = stack2.get(x);
                            posicao = stack2.indexOf(triangulo);
                            break;
                        }
                    }
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }

                if (posicao >= 0) {
                    IO.println("Triângulo de perímetro " + triangulo.perimetro() + " tem posição " + posicao);
                } else {
                    IO.println("Triângulo não encontrado!");
                }
            } else if (opcao == 8) {
                try {
                    for (int x = 0; x < stack2.size(); x++) {
                        IO.print(stack2.get(x).perimetro() + " ");
                    }
                    IO.println("");
                } catch (Exception e) {
                    IO.println(e.getMessage());
                }
            }
        }
    }
}
