import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> aVertices;
    public Vertex(V data) {
        this.data = data;
        aVertices = new HashMap<>();
    }
    public void addAVertex(Vertex<V> destination, double weight) {
        aVertices.put(destination,weight);
    }
    public V getData() {
        return data;
    }
    public Map<Vertex<V>,Double> getAVertices() {
        return aVertices;
    }
    public boolean hasAVertices(Vertex<V> destination) {
        return aVertices.containsKey(destination);
    }
    public double getWeight(Vertex<V> destination) {
        return aVertices.get(destination);
    }
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}