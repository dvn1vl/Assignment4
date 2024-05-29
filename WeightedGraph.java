import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<Vertex> {
    private boolean undirected;
    private Map<Vertex,Map<Vertex,Double>> map = new HashMap<>();
    public WeightedGraph() {
        this(true);
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex vertex) {
        map.put(vertex, new HashMap<>());
    }

    public void addEdge(Vertex source, Vertex d, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(d))
            addVertex(d);

        if (hasEdge(source, d) || source.equals(d))
            return;

        map.get(source).put(d,weight);
        map.get(d).put(source,weight);
    }

    private boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).containsKey(dest);
    }

    private boolean hasVertex(Vertex source) {
        return map.containsKey(source);
    }
    public Set<Vertex> getNeighbours(Vertex vertex) {
        if (!hasVertex(vertex))
            throw new IndexOutOfBoundsException("Vertex does not exist");
        return map.get(vertex).keySet();
    }
    public double getEdgeWeight(Vertex source, Vertex d) {
        if (!hasEdge(source, d))
            throw new IllegalArgumentException("Edge does not exist");
        return map.get(source).get(d);
    }
    public void printGraph() {
        for (Vertex vertex: map.keySet()) {
            System.out.printf("Vertex %s connected to %s\n", vertex, map.get(vertex));
        }
    }

    private void checkVertex(Vertex vertex) {
        if(!hasVertex(vertex)) throw new IndexOutOfBoundsException("Vertex does not exist");
    }



    public void removeVertex(Vertex vertex) {
        checkVertex(vertex);

        for (Vertex local : map.keySet()) {
            map.get(local).remove(vertex);
        }
        map.remove(vertex);
    }
    public void removeEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);

        map.get(source).remove(dest);
        map.get(dest).remove(source);
    }
}