import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private String name;
    private int demand;
    private List<Edge> edges;

    public Node (int id, String name) {
        this.id = id;
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public Node (int id, String name, int demand) {
        this.id = id;
        this.name = name;
        this.demand = demand;
        this.edges = new ArrayList<>();
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public int getDemand () {
        return demand;
    }

    public void setDemand (int demand) {
        this.demand = demand;
    }

    public List<Edge> getEdges () {
        return edges;
    }

    public void setEdges (List<Edge> edges) {
        this.edges = edges;
    }

    public String toString() {
        return "{id: " + id + ", name: " + name + ", demand: " + demand + ", edges: " + edges + "}";
    }
}
