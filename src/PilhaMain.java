import tipo_abstrato_dado.Pilha;

void main(){

    Scanner scanner = new Scanner(System.in);
    IO.println("Tamanho máximo da pilha: ");
    int tamanho = scanner.nextInt();
    IO.println("Informe se há ou não repetição: [false] = não, [true] = sim: ");
    boolean repete = scanner.nextBoolean();

    Pilha pilha = new Pilha(tamanho, repete);

    while(true) {

        IO.println("------------------------");
        IO.println("----------Pilha---------");
        IO.println("0 - Encerrar");
        IO.println("1 - Inserir um elemento");
        IO.println("2 - Remover um elemento");
        IO.println("3 - Imprimir pilha");
        IO.println("4 - Informar quantidade de elementos");
        IO.println("5 - Informar a posição do topo");
        IO.println("6 - Retornar posição de um elemento");

        IO.println("Digite a opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 0) {
            break;
        } else if (opcao == 1) {
            IO.println("Digite o elemento: ");
            int elemento = scanner.nextInt();

            if (!pilha.inserirElemento(elemento)) {
                IO.println("Pilha cheia ou elemento repetido!");
            }
        } else if (opcao == 2) {
            if(!pilha.removerElemento()) {
                IO.println("Não há elementos!");
            }
        } else if (opcao == 3) {
            IO.println(pilha.imprimirPilha());
        } else if (opcao == 4) {
            IO.println(pilha.quantidadeElementos());
        } else if (opcao == 5) {
            int[] posicao = pilha.posicaoTopo();
            if (posicao[1] == 0) {
                IO.println("Pilha vazia!");
            } else {
                IO.println(posicao[0]);
            }
        } else if (opcao == 6) {
            IO.println("Digite o elemento: ");
            int elemento = scanner.nextInt();
            List<Integer> posicoes = pilha.retornarPosicao(elemento);
            if (!posicoes.isEmpty()) {
                IO.println(posicoes);
            } else {
                IO.println("Elemento não encontrado!");
            }
        }
    }
}
