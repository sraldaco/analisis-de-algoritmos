package com.tarea5;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/*
 * @autor alex aldaco
 */
public class Main {

    public static void main(String[] args) {
        // tamaño de k, con k aleatoria y 1 <= k <= 20
        int k = ThreadLocalRandom.current().nextInt(1,21);
        // numero de elementos
        int size = 50 * k;
        // arreglo que contiene los elementos
        double[] arreglo = new double[size];
        // recorre el arreglo
        for(int i = 0; i < size; i++) {
            // llena el arreglo con doubles semi-aleatorios del intervalo [-size*2, size*2]
            arreglo[i] = ThreadLocalRandom.current().nextDouble(-size * 2 - 1, size * 2 + 1);
        }
        // ordena el arreglo en forma no decreciente
        Arrays.sort(arreglo);
        // imprime cada uno de los valores con su key o posición
        int key = 0; for(double i  : arreglo) {
            System.out.println("Key: " + key++ + ", Value: " + i);
        }
        // imprimimos el valor de k y de size
        System.out.println("\nvalor de k: " + k + " tamaño del arreglo: " + size);
        // extrae un valor al azar del arreglo sin recordar su posición
        double findElement = arreglo[ThreadLocalRandom.current().nextInt(0, size + 1)];
        // extrae el valor del último elemento para simular el peor caso
        //double findElement = arreglo[size-1];
        System.out.println("\nEl elemento a buscar es: " + findElement);
        // busca el elemento y regresa su key o posición
        System.out.print("\nResultado de búsqueda: ");
        double init = System.currentTimeMillis();
        int resultado = Search.exponentialSearch(arreglo, findElement);
        double end = System.currentTimeMillis() - init;
        String msg = resultado == - 1 ? "No se encuentró el elemento" : "El elemento se encuentra en la posición " + resultado;
        System.out.println(msg);
        System.out.println("\nTiempo de la búsqueda: " +  end / 1000d + "s");
    }
}
