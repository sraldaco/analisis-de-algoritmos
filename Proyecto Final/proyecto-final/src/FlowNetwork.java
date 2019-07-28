import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private int totalVertex;
    private int totalEdges;
    public ArrayList<ArrayList<Edge>> graph;

    public FlowNetwork(int totalVertex){
        this.totalVertex = totalVertex;
        graph = new ArrayList<>();
        for(int i=0; i < totalVertex; ++i){
            graph.add(new ArrayList<>());
        }
    }
    public void addEdge(Edge edge){
        int v = edge.getFrom();
        int w = edge.getTo();
        graph.get(v).add(edge);
        graph.get(w).add(edge);
        totalEdges++;
    }
    public void addSpecialVertex(List<Edge> edges) {
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        for(Edge edge : edges) {
            addEdge(edge);
            totalVertex++;
        }
    }

    public int totalVertex(){
        return totalVertex;
    }
    public int totalEdges(){
        return totalEdges;
    }

    public Iterable<Edge> adjacentTo(int vertex){
        return graph.get(vertex);
    }

    public Iterable<Edge> edges(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<totalVertex; ++i){
            edges.addAll(graph.get(i));
        }
        return edges;
    }
}

