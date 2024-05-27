import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<V> {
    private V data;
    private List<Edge<Vertex<V>>> adjacentEdges;

    public Vertex(V data) {
        this.data = data;
        this.adjacentEdges = new ArrayList<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        Edge<Vertex<V>> edge = new Edge<>(this, destination, weight);
        adjacentEdges.add(edge);
    }

    public List<Edge<Vertex<V>>> getAdjacentEdges() {
        return adjacentEdges;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
