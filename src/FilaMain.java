import tipo_abstrato_dado.Fila;
import tipo_abstrato_dado.FilaArray;

void main() {
    Scanner scanner = new Scanner(System.in);

    IO.println("Informe o tamanho máximo da fila: ");
    int tamanhoFila = scanner.nextInt();

    if (tamanhoFila <= 0) {
        IO.println("Tamanho inválido!");
    } else {
        FilaArray fila = new FilaArray(tamanhoFila);
        while(true) {
            IO.println("----------------------------------------");
            IO.println("-------------------Fila-----------------");
            IO.println("0 - encerrar");
            IO.println("1 - inserir um elemento na fila");
            IO.println("2 - remover um elemento da fila");
            IO.println("3 - imprimir a fila");
            IO.println("4 - informações gerais sobre a fila");

            IO.println("Digite a opção: ");
            int opcao = scanner.nextInt();
            float elemento;

            if (opcao == 0) {
                return;
            } else if (opcao == 1) {
                if (!fila.statusFila().equals("cheia")) {
                    IO.println("Digite o elemento a ser inserido: ");
                    elemento = scanner.nextFloat();
                    if (!fila.addElement(elemento)) {
                        IO.println("Erro ao adicionar elemento!");
                    }
                } else {
                    IO.println("Fila cheia!");
                }
            } else if (opcao == 2) {
                if (!fila.statusFila().equals("vazia")) {
                    if (!fila.removeElement()) {
                        IO.println("Erro ao remover elemento!");
                    }
                } else {
                    IO.println("Nada a remover. Fila vazia!");
                }
            } else if (opcao == 3) {
                IO.println(fila.imprimirFila());
            } else if (opcao == 4) {
                IO.println(fila.informacoesFila());
            }
        }
    }
}
