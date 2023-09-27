import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Asesino implements Comparable<Asesino> {
    protected String nombre;
    protected int fuerza;
    protected int destreza;

    public Asesino(String nombre, int fuerza, int destreza) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.destreza = destreza;
    }

    @Override
    public int compareTo(Asesino asesino) {
        return (asesino.fuerza + asesino.destreza) - (this.fuerza + this.destreza);
    }
}

class Simulacion {
    protected List<Asesino> listaAsesinos;
    protected int fuerzaTotalTemplarios;

    public Simulacion(List<Asesino> listaAsesinos, int fuerzaTotalTemplarios) {
        this.listaAsesinos = listaAsesinos;
        this.fuerzaTotalTemplarios = fuerzaTotalTemplarios;
    }

    public int derrotarTemplarios() {
        Queue<Asesino> asesinos = new PriorityQueue<>(listaAsesinos);

        int cantAtaques = 0;
        while (fuerzaTotalTemplarios > 0 && !asesinos.isEmpty()) {
            Asesino asesino = asesinos.poll();
            while (asesino.fuerza > 0 || asesino.destreza >= 5) {
                cantAtaques++;

                this.fuerzaTotalTemplarios -= (asesino.fuerza + asesino.destreza);
                if (this.fuerzaTotalTemplarios <= 0) return cantAtaques;

                asesino.fuerza /= 2;
                asesino.destreza -= 10;
            }
        }

        if (this.fuerzaTotalTemplarios < 0) return cantAtaques;
        return -1;
    }
}

public class simulacionEj {
    public static void main(String[] args) {
        Simulacion s0 = new Simulacion(
                List.of(
                        new Asesino("Ezio", 150, 100),
                        new Asesino("Altair", 100, 200),
                        new Asesino("Desmond", 60, 350),
                        new Asesino("Rebecca", 100, 120),
                        new Asesino("Daniel ", 210, 210)
                ),
                10050
        );

        System.out.println(s0.derrotarTemplarios());
    }
}
