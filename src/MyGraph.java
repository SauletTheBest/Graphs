import java.util.HashMap;
import java.util.Map;

public class MyGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V value) {
        vertices.put(value, new Vertex<>(value));
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);
        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
        }
    }

    public Vertex<V> getVertex(V value) {
        return vertices.get(value);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
