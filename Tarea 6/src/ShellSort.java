/*
 * @autor alex aldaco
 */

public class ShellSort {
    /*
     * @param array arreglo que va a ser ordenado en forma no decreciente
     * @return tiempo total de la ejecución del algoritmo para un arreglo dado
     */
    public static double sort(int[] array) {
        double init = System.currentTimeMillis();
        int n = array.length;
        // toma un intervalo del tamaño de la mitad del arreglo y lo va reduciendo a la mitad
        for (int interval = n / 2; interval > 0; interval /= 2) {
            /* hace una ordenación por inserción y va agregando elementos
             * hasta que to do el arreglo  esté ordenado por intervalos.
             */
            for (int i = interval; i < n; i++) {
                int j, tmp = array[i];
                for (j = i; j >= interval && array[j - interval] > tmp; j -= interval)
                    array[j] = array[j - interval];
                array[j] = tmp;
            }
        }
        return System.currentTimeMillis() - init;
    }
}
