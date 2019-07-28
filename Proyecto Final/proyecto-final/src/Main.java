
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try {
            Path root = Paths.get(".").normalize().toAbsolutePath();
            File data = new File(root + "/graph.txt");
            Scanner sc = new Scanner(data);
            List<Node> graph = new ArrayList<>();
            while (sc.hasNextLine()) {
                String node = sc.nextLine();
                Scanner token = new Scanner(node);
                token.useDelimiter(":");
                int id = Integer.parseInt(token.next());
                String name = token.next();
                int demand = Integer.parseInt(token.next());
                Node n = new Node(id, name, demand);
                if (token.hasNext()) {
                    List<Edge> edges = new ArrayList<>();
                    String[] flowEdges = token.next().split(";");
                    for (String edgeString : flowEdges) {
                        String[] edgeArray = edgeString.split(",");
                        Edge edge = new Edge(id, Integer.parseInt(edgeArray[0]), Integer.parseInt(edgeArray[1]));
                        edges.add(edge);
                    }
                    n.setEdges(edges);
                }
                token.close();
                graph.add(n);
            }
            sc.close();
            System.out.println("Gráfica de entrada");
            System.out.println(graph);
            CWD cwd = new CWD(graph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}