package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author alex aldaco
 */
public class Main {

    public static void main(String[] args) {
        double initTotal =  System.currentTimeMillis();
        //duración mínima y duración máxima de las tareas
        int dmin = 0, dmax = 0, index = 0, av = 0, avTR = 0;
        // lista que contiene todas las listas con tareas asignadas
        List<List<Req>> SCH = new ArrayList<>();
        // lista con tareas por asignar
        List<Req> REQ = new ArrayList<>();
        // objeto que se encarga de asignar las tareas
        Greedy greedy = new Greedy();
        double initREQ =  System.currentTimeMillis();
        // la duración máxima que puede tener una tarea
        int d = (int) (Math.random() * 24) + 1;
        //int d = 24;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i*10; j++) {
                // hora de inicio de las tareas de 0 a 23hrs
                int start = (int) (Math.random() * 24);
                // duración de una tarea de 1 a dhrs
                int interval = (int) (Math.random() * d) + 1;
                // la hora en que finaliza la tarea de 1 a 24hr
                int end = start + interval > 24 ? 24 : start + interval;
                // crea una nueva tarea con los datos aleatorios
                Req req = new Req("task: " + index++, start, end);
                // agrega la tarea a la lista de tareas en espera de asignación
                REQ.add(req);
                // duración de la tarea
                int inter = end - start;
                av += inter;
                if (i == 1) dmin = dmax = inter;
                else  dmin = inter < dmin ? inter : dmin; dmax = inter > dmax ? inter : dmax;
            }
        }
        double stopREQ = System.currentTimeMillis() - initREQ;
        // ordena las tareas en orden no decreciente por el inicio del intervalo
        double initSort = System.currentTimeMillis();
        Collections.sort(REQ, (Req reqi, Req reqj) -> new Integer(reqi.getStart()).compareTo(reqj.getStart()));
        double stopSort = System.currentTimeMillis() - initSort;
        // obtiene la lista con las tareas asignadas
        double initGreedy = System.currentTimeMillis();
        SCH = greedy.scheduleAll(REQ);
        double stopGreedy = System.currentTimeMillis() - initGreedy;
        // promedio tareas por recurso
        double initAVTR = System.currentTimeMillis();
        for(List<Req> reqs  : SCH) {
            avTR += reqs.size();
        }
        double stopAVTR = System.currentTimeMillis() - initAVTR;
        // imprime las tareas asignadas
        double initPrint = System.currentTimeMillis();
        SCH.forEach(reqs -> {
            System.out.print("Tareas en el recurso: " + reqs.size() + " => ");
            reqs.forEach(req -> {
                System.out.print(req + " | ");
            });
            System.out.println("\n----------------------------------------------"
                    + "---------------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "---------------------------------------------------------");
        });
        double currentTime = System.currentTimeMillis(), stopPrint, stopTotal;
        stopPrint = currentTime - initPrint; stopTotal = currentTime - initTotal;
        System.out.println("\n---------------------------------------");
        System.out.println("| DATO                     | VALOR    |");
        System.out.println("---------------------------------------");
        System.out.println("| Duración mínima          | " + dmin + "        |");
        System.out.println("| Duración máxima          | " + dmax + "       |");
        System.out.println("| Duración promedio        | " + av/index + "        |");
        System.out.println("| Total de tareas (n)      | " + index + "    |");
        System.out.println("| Total de recursos (SCH)  | " + SCH.size() + "    |");
        System.out.println("| Promedio tareas/recursos | " + avTR/SCH.size() + "       |");
        System.out.println("| Tiempo REQ               | " + stopREQ/1000 + "s   |");
        System.out.println("| Tiempo sort              | " + stopSort/1000 + "s   |");
        System.out.println("| Tiempo greedy            | " + stopGreedy/1000 + "s  |");
        System.out.println("| Tiempo promedio T/R      | " + stopAVTR/1000 + "s  |");
        System.out.println("| Tiempo impresión         | " + stopPrint/1000 + "s  |");
        System.out.println("| Tiempo total             | " + stopTotal/1000 + "s  |");
        System.out.println("--------------------------------------- \n");
    }

}
