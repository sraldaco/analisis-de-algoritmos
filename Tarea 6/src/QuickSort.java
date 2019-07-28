/*
 * @autor alex aldaco
 */

public class QuickSort {

    /*
     * @param arreglo que va a ser ordenado en forma no decreciente
     * @return tiempo total de la ejecución del algoritmo para un arreglo dado
     */
    public static double sort(int[] array) {
        double init = System.currentTimeMillis();
        sort(array, 0, array.length -1);
        return System.currentTimeMillis() - init;
    }

    /*
     * @param array el arreglo a ser ordenado
     * @param low comienzo de la partición del arreglo a ordenar
     * @param high final de la partición a ordenar
     */
	private static void sort(int[] array, int low, int high) {
		int index = partition(array, low, high);
		// llamada recursiva con la parte izquierda del arreglo
		if (low < index - 1) sort(array, low, index - 1);
        // llamada recursiva con la parte derecha del arreglo
		if (high > index) sort(array, index, high);
    }

    /*
     * @param array el arreglo a ser ordenado
     * @param low comienzo de la partición del arreglo a dividir
     * @param high final de la partición a dividir
     * @return indice que divide la partición
     */
	private static int partition(int[] array, int low, int high) {
        // el primer elemento es el pivote
        int pivot = array[low];
        while (low <= high) {
            // incrementa hasta encontrar un número más grande que el pivote
            while (array[low] < pivot) { low++; }
            // decrementa hasta encontrar un número más chico que el pivote
            while (array[high] > pivot) { high--; }
            // intercambia posiciones
            if (low <= high)  { swap(array, low, high); low++; high--; }
        }
        return low;
    }

    /*
     * @param array el arreglo en el que se van a intercambiar valores
     * @param low indice a ser intercambiado de valor
     * @param high indice a ser intercambiado de valor
     */
    private static void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
