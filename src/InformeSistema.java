import java.lang.System;
import java.lang.Runtime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

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

    public static void propiedadesSistema(String[] args) {
        List <String> prefijos;
        if (args.length > 0) {
            prefijos = Arrays.asList(args);
        } else {
            prefijos = List.of("os.", "user.", "java.version");
        }

        System.out.println("Prefijos utilizados: " + prefijos);
        System.out.println("==================================================");
        System.getProperties().stringPropertyNames().stream()
                .filter(clave -> prefijos.stream().anyMatch(clave::startsWith))
                .sorted().forEach(clave -> System.out.println(clave + " = " + System.getProperty(clave)));

    }

}
