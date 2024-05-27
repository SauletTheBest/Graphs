import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        this.distTo = new HashMap<>();
        initializeDistances(source);
        distTo.put(source, 0.0);
        search(source);
    }

    private void initializeDistances(Vertex<V> source) {
        for (Vertex<V> vertex : getAllVertices(source)) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
    }

    private Iterable<Vertex<V>> getAllVertices(Vertex<V> source) {
        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        visitAllVertices(source, visited);
        return visited.keySet();
    }

    private void visitAllVertices(Vertex<V> vertex, Map<Vertex<V>, Boolean> visited) {
        if (visited.containsKey(vertex)) return;
        visited.put(vertex, true);
        for (Edge<Vertex<V>> edge : vertex.getAdjacentEdges()) {
            visitAllVertices(edge.getDest(), visited);
        }
    }

    @Override
    public void search(Vertex<V> source) {
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>();
        pq.add(new VertexDistance<>(source, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> vd = pq.poll();
            Vertex<V> v = vd.getVertex();
            marked.put(v, true);  // Mark this node as visited

            for (Edge<Vertex<V>> edge : v.getAdjacentEdges()) {
                Vertex<V> w = edge.getDest();
                double weight = edge.getWeight();
                double newDist = distTo.get(v) + weight;
                if (newDist < distTo.get(w)) {
                    distTo.put(w, newDist);
                    edgeTo.put(w, v);
                    pq.add(new VertexDistance<>(w, newDist));
                }
            }
        }
    }

    private class VertexDistance<T> implements Comparable<VertexDistance<T>> {
        private final Vertex<T> vertex;
        private final Double distance;

        public VertexDistance(Vertex<T> vertex, Double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex<T> getVertex() {
            return vertex;
        }

        @Override
        public int compareTo(VertexDistance<T> o) {
            return this.distance.compareTo(o.distance);
        }
    }
}
