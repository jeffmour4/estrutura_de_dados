package tipo_abstrato_dado;

public class Numero {

    public Numero() {
        this.valor = 0;
    }

    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor < 0 ) {
            valor = 0;
            msg("Valor menor que zero -> corrigido para zero");
        } else if (valor > 40 && valor < 50) {
            valor = 40;
            msg("valor no intervalor não suportado -> corrigido para 40");
        } else if (valor >= 50 && valor < 60) {
            valor = 60;
            msg("valor no intervalo não suportado -> corrigido para 60");
        } else if (valor > 100) {
            valor = 100;
            msg("valor maior que 100 -> corrigido para 100");
        }
        this.valor = valor;
        IO.println("Novo valor atribuído");
    }

    public void msg(String msg) {
        IO.println("Atenção: " + msg);
    }
}