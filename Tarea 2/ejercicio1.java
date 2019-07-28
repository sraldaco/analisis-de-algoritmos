/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea2;

/**
 *
 * @author alex aldaco
 */
public class ejercicio1 {
    
    public static void main(String args[]) {
        int r = 0;
        int n = 2;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i*i; j++) {
                for (int k = 1; k <= n; k++) {
                    r += 1;
                    System.out.println("i: " + i + ", j: " + j + ", k: " + k + ", r: " + r);
                }
            }
        }
        
    }
}

