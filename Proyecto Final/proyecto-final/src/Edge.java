public class Edge {
    private final int from;
    private final int to;
    private double capacity;
    private double flow;

    public Edge(int from, int to, double capacity){
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }

    public int getFrom(){
        return from;
    }
    public int getTo(){
        return to;
    }
    public int otherVertex(int vertex){
        if (vertex == this.from) return to;
        return from;
    }

    public double getCapacity(){
        return capacity;
    }
    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public double getFlow(){
        return flow;
    }

    public double residualCapacityTo(int vertex){
        if(vertex == to) return  capacity - flow;
        return flow;
    }

    public void addResidualFlowTo(int vertex, double inFlow){
        if(vertex==this.to) flow += inFlow;
        else flow -= inFlow;
    }

    @Override
    public String toString() {
        return "[" + from + " -> " + to + ", capacidad: " + capacity + ", flujo: " + flow + "]";
    }
}

