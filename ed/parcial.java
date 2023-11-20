import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Libro implements Comparable<Libro> {
    protected int cantHojas;
    protected boolean aColor;

    public Libro(int cantHojas, boolean aColor) {
        this.cantHojas = cantHojas;
        this.aColor = aColor;
    }

    @Override
    public int compareTo(Libro libro) {
        if (this.cantHojas != libro.cantHojas)
            return this.cantHojas - libro.cantHojas;
        if (!this.aColor && libro.aColor)
            return -1;
        if (this.aColor && !libro.aColor)
            return 1;
        return 0;
    }
}

class Impresion {
    private int cantHojasExistencia;
    private LinkedList<Libro> libros;

    public Impresion(int cantHojasExistencia, LinkedList<Libro> libros) {
        this.cantHojasExistencia = cantHojasExistencia;
        this.libros = libros;
    }

    public int librosImpresosAColor() {
        PriorityQueue<Libro> librosPQ = new PriorityQueue<>(libros);
        int cantImpresosAColor = 0;

        while (!librosPQ.isEmpty() && cantHojasExistencia > 0) {
            Libro libro = librosPQ.poll();
            boolean aColor = libro.aColor;
            int cantHojas = libro.cantHojas;

            if (cantHojas <= 500) {
                if (aColor)
                    cantImpresosAColor += cantHojas;
                cantHojasExistencia -= cantHojas;
            } else {
                if (aColor)
                    cantImpresosAColor += 500;
                cantHojasExistencia -= 500;
                libro.cantHojas -= 500;
                librosPQ.add(libro);
            }
        }

        return cantImpresosAColor;
    }

    public int librosImpresosAColorFixed() {
        PriorityQueue<Libro> librosPQ = new PriorityQueue<>(libros);
        int cantImpresosAColor = 0;

        while (!librosPQ.isEmpty() && cantHojasExistencia != 0) {
            Libro libro = librosPQ.poll();
            boolean aColor = libro.aColor;
            int cantHojas = libro.cantHojas;

            if (cantHojas <= 500) {
                int cantQuePuedenSerImpresas = Math.min(cantHojasExistencia, cantHojas);

                if (aColor)
                    cantImpresosAColor += cantQuePuedenSerImpresas;
                cantHojasExistencia -= cantQuePuedenSerImpresas;
            } else {
                int cantQuePuedenSerImpresas = Math.min(cantHojasExistencia, 500);

                if (aColor)
                    cantImpresosAColor += cantQuePuedenSerImpresas;
                cantHojasExistencia -= cantQuePuedenSerImpresas;
                libro.cantHojas -= cantQuePuedenSerImpresas;
                librosPQ.add(libro);
            }
        }

        return cantImpresosAColor;
    }
}


public class parcial {
    public static void main(String[] args) {
        Impresion imp = new Impresion(
                300,
                new LinkedList<>(List.of(
                        new Libro(100, true),
                        new Libro(400, false),
                        new Libro(501, true),
                        new Libro(30, true),
                        new Libro(100, false)
                ))
        );

        System.out.println(imp.librosImpresosAColor()); // 130
    }
}
