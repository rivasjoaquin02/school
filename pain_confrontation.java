import java.util.List;
import java.util.PriorityQueue;

class Soldado implements Comparable<Soldado>{
    protected int fuerza;
    protected String nombre;

    Soldado(String nombre, int fuerza) {
        this.fuerza = fuerza;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Soldado o) {
        return o.fuerza - this.fuerza;
    }
}

class Konoha {
    protected List<Soldado> listaSoldados;

    public Konoha(List<Soldado> soldados) {
        this.listaSoldados = soldados;
    }

//    O(nlogm)
    public int derrotarPain(int painVida) {
        PriorityQueue<Soldado> pq = new PriorityQueue<>(listaSoldados);

        int numeroAtaques = 0;
        while (painVida >= 0 && !pq.isEmpty()) {
            Soldado soldado = pq.poll();

            while (soldado.fuerza > 0) {
                numeroAtaques++;

                if (painVida - soldado.fuerza <= 0){
                    System.out.println("Victoria");
                    return numeroAtaques;
                }

                painVida -= soldado.fuerza;
                soldado.fuerza /= 2;
            }
        }
        System.out.println("Evacuen");
        return -1;
    }

}


public class pain {
    public static void main(String[] args) {
        Konoha aldeaOculta = new Konoha(
                List.of(
                        new Soldado("naruto", 150),
                        new Soldado("shikamaru", 200),
                        new Soldado("kakashi", 120)
//                        new Soldado("pakun", 170)
                )
        );

        System.out.println(aldeaOculta.derrotarPain(1000));
    }
}
