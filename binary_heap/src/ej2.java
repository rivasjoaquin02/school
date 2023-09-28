import java.util.List;

class Soldado {
    protected String nombre;
    protected int fuerza;
    protected int vida;

    Soldado(String nombre, int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
    }
}

class Konoha {
    protected List<Soldado> listaSoldado ;

    Konoha (List<Soldado> listaSoldado) {
        this.listaSoldado = listaSoldado;
    }

    int derrotarPain(int painFuerza) {

        for (Soldado soldado: listaSoldado) {
            int fuerzaSoldado = (soldado.vida / 2) * soldado.fuerza;

            if (painFuerza < fuerzaSoldado) {

            }

        }

    }
}


public class ej2 {
    public static void main(String[] args) {

    }
}
