package com.rep4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Search {
    public static int index = 1;
    public static void main(String[] args) {
        int n = 500;
        float[] array = new float[n];
        for (int i = 0; i < n; i++) {
            array[i] = (float) ThreadLocalRandom.current().nextInt(-n-1, n+1);
        }
        int i = ThreadLocalRandom.current().nextInt(0, n);
        float element = array[i];
        System.out.println(Arrays.toString(array));
        System.out.println("Se toma el elemento de la posición " + i + " para hacer la comparación");
        System.out.println("El elemento a buscar es: " + element);
        int low = 0, high = array.length -1, index = 0;
        int pos = find(element,low, high, array);
        System.out.println("\nposición: " + (pos != -1 ? pos : "No se encontró el elemento"));
    }

    public static int find(float element, int low, int high, float[] array) {
        if (low > high) return -1;
        int medium = (low + high) / 2;
        System.out.println(index++ + " - Buscando en: " + medium + " intervalo: [" + low + "," + high + "]");
        if(array[medium] == element) return medium;
        int pos;
        if ((pos = find(element, low, medium-1, array)) != -1) return pos;
        if ((pos = find(element, medium+1, high, array)) != -1) return pos;
        return -1;
    }
}
