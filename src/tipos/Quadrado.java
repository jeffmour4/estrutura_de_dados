package tipos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @class Quadrado
 * @author Marcio Porto Feitosa - 26/10/2022 - 10:38:51
 */
public class Quadrado {

    public Quadrado(float lado) {
        this.lado = lado;
    }

    private final float lado;

    public float getLado() {
        return this.lado;
    }

    public double perimetro() {
        return 2 * this.lado;
    }

    public double area() {
        return Math.pow(this.lado, 2);
    }

    public double diagonal() {
        return Math.sqrt(2 * Math.pow(this.lado, 2));
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Quadrado)) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if (obj == this) {
            return true;
        }
        
        Quadrado q = (Quadrado) obj;
        
        return q.getLado() == this.getLado();

    }

}
