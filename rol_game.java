import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Jugador  implements Comparable<Jugador> {
    protected String id;
    protected int horasJuego;
    protected int puntosLogro;

    public Jugador(int horasJuego, int puntosLogro) {
        this.id = String.valueOf(Math.random());
        this.horasJuego = horasJuego;
        this.puntosLogro = puntosLogro;
    }


    @Override
    public int compareTo(Jugador jugador) {
        if (this.horasJuego < jugador.horasJuego) return -1;
        else if (this.horasJuego > jugador.horasJuego) return 1;
        return jugador.puntosLogro - this.puntosLogro;
    }

    public String toString() {
        return id + horasJuego + puntosLogro;
    }
}

class Servidor {
    protected List<Jugador> jugadores;
    protected Queue<Jugador> jugadoresEnEspera;

    public Servidor(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        jugadoresEnEspera = new PriorityQueue<>(jugadores);
    }

    public List<Jugador> estadoCola() {
        List<Jugador> estado = new ArrayList<>();

        while (!jugadoresEnEspera.isEmpty()) {
            estado.add(jugadoresEnEspera.poll());
        }
        return estado;
    }
}


public class rolGame {
    public static void main(String[] args) {
        Servidor s0 = new Servidor(
                List.of(
                        new Jugador(100, 20),
                        new Jugador(50, 20),
                        new Jugador(200, 20),
                        new Jugador(100, 60)
                )
        );

        List <Jugador> sol = s0.estadoCola();
        System.out.println(sol);
    }
}
