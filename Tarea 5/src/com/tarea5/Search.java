package com.tarea5;

/*
 * @autor alex aldaco
 */
public class Search {
    /*
     * @param elements es el arreglo que contiene los elementos
     * @param findElement es el elemento a encontrar
     * @return resultado de la búsqueda binaria del elemento
     */
    public static int exponentialSearch(double[] elements, double findElement) {
        int size = elements.length;
        if (size == 0) return -1;
        if (size == 1) return elements[0] == findElement ? 0 : -1;
        int low = 0, high = 1;
        while (elements[high] < findElement) {
            low = high;
            high = high * 2 > size - 1 ? size - 1 : high * 2;
        }
        return binarySearch(elements, findElement, low, high);
    }
    /*
     * @param elements es el arreglo que contiene los elementos
     * @param findElement es el elemento a encontrar
     * @param low inicio del intervalo de búsqueda
     * @param high final del intervalo de búsqueda
     * @return posición del elemento o -1 si no se encontró
     */
    private static int binarySearch(double[] elements, double findElement, int low, int high) {
        while (low <= high) {
            int medium = (low + high) / 2;
            if (elements[medium] < findElement) low = medium + 1;
            else if (elements[medium] > findElement) high = medium - 1;
            else  return medium;
        }
        return -1;
    }
}
