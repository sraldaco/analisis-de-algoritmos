/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea1;

/**
 *
 * @author alex aldaco
 */
public class Circunferencia {
    int n = 16;
    int count = 1;

    public Circunferencia() {
        if (n <= 0) return;
        System.out.println("n = " + n);
        System.out.println(count + ": (0.0) -> 0 < " + n);
        for (int x = 0; x <= n; x++) {
           for (int y = 0; y <= n; y++) {
                if (x == 0 && y == 0) {
                   continue;
                }
                int h = x*x*x*x + 2*x*x*y*y + y*y*y*y;
                if (n*n > h) {
                    count++;
                    System.out.println(count + ": (" + x + "," + y + ") -> " + (x*x+y*y) + " < " + n);
                }
           }
        }
        System.out.println("El total de parejas (x,y) son " + count);
    }

    public static void main(String[] args){
        Circunferencia c = new Circunferencia();
    }

}
