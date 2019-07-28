import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CWD {
    private double maxFlow = 0;
    private int demands = 0;
    private int offers = 0;
    private boolean[] visited;
    private Edge[] parent;

    public CWD(List<Node> nodes) {
        int source = nodes.size();
        int sink = source + 1;
        FlowNetwork graph = new FlowNetwork(sink + 1);
        Node sourceNode = new Node(source, "S"), sinkNode = new Node(sink, "T");
        List<Edge> sourceEdges = new ArrayList<>();
        for (Node node : nodes) {
            int demand = node.getDemand();
            if (demand > 0) {
                Edge edge = new Edge(node.getId(), sink, demand);
                List<Edge> nodeEdges = node.getEdges();
                nodeEdges.add(edge); node.setEdges(nodeEdges);
                graph.addEdge(edge);
                demands += demand;
            } else if (demand < 0) {
                Edge edge = new Edge(source, node.getId(), -demand);
                sourceEdges.add(edge);
                graph.addEdge(edge);
                offers += -demand;
            }
            node.getEdges().forEach(graph::addEdge);
        }
        sourceNode.setDemand(-offers); sourceNode.setEdges(sourceEdges); sinkNode.setDemand(demands);
        nodes.add(sourceNode); nodes.add(sinkNode);
        System.out.println("Gráfica instanciada con S y T");
        System.out.println(nodes);
        if (demands == offers) {
            //maxFlow = 0;
            while(hasAugmentingPath(graph, source, sink)){
                double bottneck = Double.POSITIVE_INFINITY;
                ArrayList<Integer> incrementPath = new ArrayList<>();
                for (int v = sink; v != source; v =parent[v].otherVertex(v)) {
                    incrementPath.add(v);
                    bottneck = Math.min(bottneck, parent[v].residualCapacityTo(v));
                }
                for(int v = sink; v != source; v = parent[v].otherVertex(v)) {
                    parent[v].addResidualFlowTo(v, bottneck);
                }
                System.out.print("Ruta incrementable: ");
                System.out.print(nodes.get(source).getName());
                for(int i = incrementPath.size() - 1; i >= 0; i--){
                    System.out.print(" -> "+nodes.get(incrementPath.get(i)).getName());
                }
                System.out.println(", Capacidad mínima: "+ bottneck);
                System.out.print("Gráfica residual: ");
                System.out.println(graph.edges());
                maxFlow += bottneck;
            }
        }

        displayOutputMessages(graph, nodes);
    }


    //BFS
    private boolean hasAugmentingPath(FlowNetwork graph, int source, int sink){
        parent = new Edge[graph.totalVertex()];
        visited = new boolean[graph.totalVertex()];
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(source);
        visited[source] = true;
        while(!nodeQueue.isEmpty()){
            int node = nodeQueue.poll();
            for(Edge edge : graph.adjacentTo(node)){
                int otherVertex = edge.otherVertex(node);
                if(edge.residualCapacityTo(otherVertex)>0 && !visited[otherVertex]) {
                    parent[otherVertex] = edge;
                    visited[otherVertex] = true;
                    nodeQueue.add(otherVertex);
                }
            }
        }
        return visited[sink];
    }


    private boolean hasCirculation(){
        return maxFlow == offers && maxFlow == demands;
    }

    private void displayOutputMessages(FlowNetwork graph, List<Node> nodes){
        if (hasCirculation()) {
            System.out.println("Existe una circulación factible \nFlujo máximo: "+ maxFlow);
            System.out.print("Cortadura mínima: ");
            for (int v=0; v < graph.totalVertex(); ++v) {
                if (visited[v]) {
                    System.out.print(nodes.get(v).getName());
                }
            }
        } else {
            System.out.println("No existe una circulación factible en la gráfica");
            System.out.println("La oferta y la demanda no coinciden");
            System.out.println("Demanda total= " + demands);
            System.out.println("Oferta total= "+ offers);
        }
    }
}
