import tipo_abstrato_dado.Numero;

void main() {

    Scanner scanner = new Scanner(System.in);

    Numero numero = new Numero();

    while (true) {
        IO.println("**** TAD Número ****");
        IO.println("********************");
        IO.println("0 - encerrar");
        IO.println("1 - ler valor");
        IO.println("2 - atribuir valor");
        IO.println("");
        IO.println("Qual sua opção?");

        int opcao = scanner.nextInt();

        if(opcao == 0) {
            break;
        } else if (opcao == 1) {
            IO.println("Número é: " + numero.getValor());
        } else if (opcao == 2) {
            IO.println("Forneça um novo valor: ");
            float valor = scanner.nextFloat();
            numero.setValor(valor);
        }
    }
    IO.println("***** FIM *****");
    IO.println("Até a próxima.");
}