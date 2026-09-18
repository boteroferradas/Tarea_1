public class Main {
    public static void main (String[] args) {
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
        System.out.println("file.separator: '" + separador+ "'");
        System.out.println("Ruta construida con las propiedades: ");
        String ruta = userHome + separador + "psp" + separador + "informe.txt";
        System.out.println(ruta);

        System.out.println("PROPIEDADES QUE EMPIEZAN POR os., user., java.version");
        System.out.println("==================================================");

    }
}
