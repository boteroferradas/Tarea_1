import java.lang.System;
import java.lang.Runtime;
import java.util.Scanner;

public class InformeSistema {

    public static int n_procesadores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long memoria_reservada() {
        return Runtime.getRuntime().totalMemory();
    }

    public static long memoria_libre() {
        return Runtime.getRuntime().freeMemory();
    }

    public static long memoria_uso() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long memoria_maxima() {
        return Runtime.getRuntime().maxMemory();
    }

    public static String uso_porcentaje(){
        long uso = memoria_uso();
        long total = memoria_reservada();

        if (total == 0) return "0%";

        double porcentaje = ((double) uso / total) * 100;
        return String.format("%.2f%%", porcentaje);
    }

    public static long convertirBaMB(long bytes){
        return bytes / (1024L * 1024L);
    }

    public static String propiedadesSistema() {
        Scanner teclado = new Scanner(System.in);
    }

}
