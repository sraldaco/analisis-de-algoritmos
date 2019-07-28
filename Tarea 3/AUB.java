/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author alex aldaco
 */
public class AUB {
    public static void main(String args[]) {
        //Conjunto B
        Integer[] A = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        //Conjunto A
        Integer[] B = new Integer[] {7,8,9,10,11,12,13,14,15,16,17,18};
        List<Integer> AUB = new ArrayList<>();
        /*AUB inicialmente es A, el código siguiente sólo 
          *inicializa la lista con los elementos de A. No efectúa ninguna operación
          */
        AUB = Stream.of(A).collect(Collectors.toList());
        //Se recorren todos los elementos de B
        for (int b : B) {
            int c = 0;
            //Se compara el elemento de B con todos los elemenatos de A
            for (int a : A) {
                //Si el elemento de B es igual a algún elemento de A se brinca al siguiente elemento
                if (a == b) c++;
            }
            //Si el elemento no es igual a ningún elemento de A se inserta en AUB que inicialmente es A
            if (c == 0) AUB.add(b);
        }
        //Imprime AUB
        System.out.println(AUB);
    }

}

