import tipo_abstrato_dado.Numero;
import tipo_abstrato_dado.Vetor;

void main(){

    Scanner scanner = new Scanner(System.in);

    Vetor vetor = new Vetor(10,1,99,true);

    while(true) {
        IO.println("___________________________");
        IO.println("-----------Vetor----------");
        IO.println("0 - Encerrar");
        IO.println("1 - Atribuir um valor a determinada posição");
        IO.println("2 - Alterar o valor de determinada posição");
        IO.println("3 - Remover o valor de determinada posição");
        IO.println("4 - Ler o conteúdo de uma posição");
        IO.println("5 - Localizar um valor e retornar sua posição");
        IO.println("6 - Inserir na primeira posição vaga");
        IO.println("7 - Remover da última posição ocupada");
        IO.println("8 - Imprimir o conteúdo do vetor");

        IO.println(("Sua opção: "));
        int opcao = scanner.nextInt();
        int posicao = 0;
        int valor = 0;

        if (opcao == 0) {
            break;
        } else if (opcao == 1) {
            IO.println("Digite a posição: ");
            posicao = scanner.nextInt();
            IO.println("Digite o valor: ");
            valor = scanner.nextInt();
            if(vetor.validaPosicao(posicao) && vetor.validaValor(valor, vetor.getRepetido())) {
                if(!vetor.atribuirValor(posicao, valor)) {
                    IO.println("Posição ocupada!");
                }
            } else {
                IO.println("Posição ou valor inválido!");
            }

        } else if (opcao == 2) {
            IO.println("Digite a posição: ");
            posicao = scanner.nextInt();
            IO.println("Digite o valor: ");
            valor = scanner.nextInt();
            if(vetor.validaPosicao(posicao) && vetor.validaValor(valor, vetor.getRepetido())){
                if(!vetor.alterarValor(posicao, valor)) {
                    IO.println("Posição vazia!");
                }
            } else {
                IO.println("Posição ou valor inválido!");
            }

        } else if (opcao == 3) {
            IO.println("Digite a posição: ");
            posicao = scanner.nextInt();
            if(vetor.validaPosicao(posicao)) {
                if (!vetor.excluirValor(posicao)) {
                    IO.println("Posição vazia!");
                }
            } else {
                IO.println("Posição inválida!");
            }

        } else if (opcao == 4) {
            IO.print("Digite a posição: ");
            posicao = scanner.nextInt();
            if (vetor.validaPosicao(posicao)) {
                valor = vetor.retornaValor(posicao);
                if (valor != -1) {
                    IO.println(valor);
                } else {
                    IO.println("Posição vazia!");
                }
            } else {
                IO.println("Posição inválida!");
            }

        } else if(opcao == 5) {
            IO.println("Digite o valor: ");
            valor = scanner.nextInt();
            List<Integer> posicoes;
            if(vetor.validaValor(valor, vetor.getRepetido())) {
                posicoes = vetor.retornaPosicao(valor);
                if (!posicoes.isEmpty()) {
                    String indexes = "";
                    for (Integer index: posicoes) {
                        indexes.concat(Integer.toString(index)).concat(", ");
                    }
                    IO.println(indexes);
                    IO.println(posicoes);
                } else {
                    IO.println("Valor não encontrado!");
                }
            } else {
                IO.println("Valor !");
            }

        } else if (opcao == 6) {
            IO.println("Digite o valor: ");
            valor = scanner.nextInt();
            if (vetor.validaValor(valor, vetor.getRepetido())) {
                if (!vetor.inserirPrimeiraVaga(valor)) {
                    IO.println("Não há posiçao vaga!");
                }
            } else {
                IO.println("Valor inválido!");
            }

        } else if (opcao == 7) {
            if (!vetor.removerUltimoElemento()) {
                IO.println("Não há elementos para remover!");
            }
        } else if (opcao == 8) {
            IO.println(vetor.imprimirVetor());
        }
    }

}
