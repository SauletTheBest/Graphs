import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> source) {
        super(source);
        search(source);
    }

    @Override
    public void search(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(source);
        marked.put(source, true);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Edge<Vertex<V>> edge : v.getAdjacentEdges()) {
                Vertex<V> w = edge.getDest();
                if (!marked.getOrDefault(w, false)) {
                    edgeTo.put(w, v);
                    marked.put(w, true);
                    queue.add(w);
                }
            }
        }
    }
}
