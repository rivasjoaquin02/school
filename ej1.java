import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class TrabajoImp implements Comparable<TrabajoImp> {
    protected String nombre;
    protected int cantHojas;

    TrabajoImp(String nombre, int CantHojas){
        this.nombre = nombre;
        this.cantHojas = CantHojas;
    }
    String getNombre() {
        return this.nombre;
    }
    int getCantHojas() {return this.cantHojas;}

    @Override
    public int compareTo(TrabajoImp o2) {
        return this.cantHojas - o2.getCantHojas();
    }

}

class DriverImpresora {
    protected List<TrabajoImp> listaTrababjos;

    DriverImpresora(List <TrabajoImp> listaTrababjos) {
        this.listaTrababjos = new ArrayList<>(listaTrababjos);
    }

    List<TrabajoImp> proximosTrabajos () {
        PriorityQueue <TrabajoImp> pq = new PriorityQueue<>(this.listaTrababjos);
        List <TrabajoImp> ans = new ArrayList<>();

        for (int i=0; i<10 && !pq.isEmpty(); i++) {
            TrabajoImp ti = pq.poll();
            ans.add(ti);
        }
        return ans;
    }
}

public class ej1 {
    public static void main(String[] args) {
        DriverImpresora dv = new DriverImpresora(
                List.of(
                        new TrabajoImp("a", 45),
                        new TrabajoImp("b", 23),
                        new TrabajoImp("c", 767),
                        new TrabajoImp("d", 1)
                )
        );

        List <TrabajoImp> sol = dv.proximosTrabajos();

    }
}
