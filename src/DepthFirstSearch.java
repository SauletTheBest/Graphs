import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(Vertex<V> source) {
        super(source);
        search(source);
    }

    @Override
    public void search(Vertex<V> source) {
        Stack<Vertex<V>> stack = new Stack<>();
        stack.push(source);
        marked.put(source, true);

        while (!stack.isEmpty()) {
            Vertex<V> v = stack.pop();

            for (Edge<Vertex<V>> edge : v.getAdjacentEdges()) {
                Vertex<V> w = edge.getDest();
                if (!marked.getOrDefault(w, false)) {
                    edgeTo.put(w, v);
                    marked.put(w, true);
                    stack.push(w);
                }
            }
        }
    }
}
