import java.lang.System;
import java.lang.Runtime;
import java.util.Arrays;
import java.util.List;
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

    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (true) {

            System.out.println("PROCESADORES");
            System.out.println("==================================================");
            System.out.println("    Disponibles JVM:" + InformeSistema.n_procesadores());

            System.out.println("MEMORIA - ANTES");
            System.out.println("==================================================");
            long usoantes = InformeSistema.memoria_uso();
            System.out.println("    Total reservada:        " + InformeSistema.convertirBaMB(InformeSistema.memoria_reservada()) + " MiB");
            System.out.println("    Libre:      " + InformeSistema.convertirBaMB(InformeSistema.memoria_libre()) + " MiB");
            System.out.printf("    En uso:      " + InformeSistema.convertirBaMB(usoantes) + " MiB");
            System.out.println(" (" + InformeSistema.uso_porcentaje() + " de la total)");
            System.out.println("    Maxima:     " + InformeSistema.convertirBaMB(InformeSistema.memoria_maxima()) + " MiB");
            long[] reservado = new long[8 * 1024 * 1024];

            System.out.println("MEMORIA - DESPUES DE RESERVAR 64 MIB");
            System.out.println("==================================================");
            long usodepues = InformeSistema.memoria_uso();
            System.out.println("    Total reservada:        " + InformeSistema.convertirBaMB(InformeSistema.memoria_reservada()) + " MiB");
            System.out.println("    Libre:      " + InformeSistema.convertirBaMB(InformeSistema.memoria_libre()) + " MiB");
            System.out.printf("    En uso:      " + InformeSistema.convertirBaMB(InformeSistema.memoria_uso()) + " MiB");
            System.out.println(" (" + InformeSistema.uso_porcentaje() + " de la total)");
            System.out.println("    Maxima:     " + InformeSistema.convertirBaMB(InformeSistema.memoria_maxima()) + " MiB");
            long incrementoMemoria = usodepues - usoantes;
            System.out.println("    Incremento en uso: " + InformeSistema.convertirBaMB(incrementoMemoria) + "MiB");
            System.out.println("El array sigue en memoria: reservado[0] = " + reservado[0]);

            System.out.println("SISTEMA");
            System.out.println("==================================================");
            String sistema = System.getProperty("os.name");
            String separador = System.getProperty("file.separator");
            String userHome = System.getProperty("user.home");
            System.out.println("os.name: " + sistema);
            System.out.println("file.separator: '" + separador + "'");
            System.out.println("Ruta construida con las propiedades: ");
            String ruta = userHome + separador + "psp" + separador + "informe.txt";
            System.out.println(ruta);

            String[] prefijos = {"os.", "user.", "java.version"};
            InformeSistema.propiedadesSistema(prefijos);

            System.out.println("PROCESO EN ESPERA");
            System.out.println("==================================================");
            System.out.println("    Buscame desde otra terminal con:");
            System.out.println("        ps -ef | grep InformeSistema");
            System.out.println(" ");
            System.out.println("Pulsa INTRO para terminar...");

            if (teclado.nextLine().isEmpty()) {
                System.out.println("Fin del programa.");
                break;
            }
        }
    }
}
