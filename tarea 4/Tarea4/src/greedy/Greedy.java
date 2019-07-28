package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex aldaco
 */
public class Greedy {
    private List<List<Req>> SCH;
    private List<Req> REQ;

    public Greedy() {
        // lista que contiene los recursos
        this.SCH = new ArrayList<>();
        // es el primer recurso
        this.REQ = new ArrayList<>();
        // agrega el primer recurso (min)
        SCH.add(REQ);
    }

    /*
     * @param wait es la lista con las tareas por asignar
     * @return la lista con las tareas asignadas
     */
    public List<List<Req>> scheduleAll(List<Req> wait) {
        // si la lista de tareas por asignar viene vacia regresa nulo
        if (wait.isEmpty())
            return null;
        // obtiene el primer elemento de la lista y lo remueve de la lista
        Req req = wait.get(0);
        wait.remove(0);
        // agrega el elemento al primer recurso disponible
        SCH.get(0).add(req);
        // si la lista de tareas por asignar aun contiene elementos se asignan a algún
        // recurso
        while (!wait.isEmpty()) {
            req = wait.get(0);
            wait.remove(0);
            boolean asigned = false;
            // iteramos sobre la lista de los recursos disponibles
            for (List<Req> reqs : SCH) {
                // saca el último elemento del recurso en cada iteración
                Req r = reqs.get(reqs.size() - 1);
                // si el último elemento del recurso es compatible con la tarea se asigna la
                // tarea a el recurso de la iteración
                if (areCompatible(r, req)) {
                    reqs.add(req);
                    asigned = true;
                    break;
                }
            }
            // en otro caso se crea un nuevo recurso y se asigna la tarea al nuevo recurso
            if (!asigned) {
                List<Req> reqs = new ArrayList<>();
                reqs.add(req);
                // se agrega el nuevo recurso a la lista que contiene los recursos
                SCH.add(reqs);
            }

        }
        return SCH;
    }

    /*
     * @param i es la tarea asignada
     * @param j es la tarea por asignar return regresa un booleano que dice si son
     * compatibles las tareas
     */
    private boolean areCompatible(Req i, Req j) {
        int end = i.getEnd();
        int start = j.getStart();
        return end <= start;
    }
}
