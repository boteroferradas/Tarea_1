import java.lang.Runtime;

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
        return Runtime.getRuntime().totalMemory();
    }
}
