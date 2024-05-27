import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Map<Vertex<V>, Boolean> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    public abstract void search(Vertex<V> source);

    public boolean hasPathTo(Vertex<V> v) {
        return marked.getOrDefault(v, false);
    }

    public List<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> x = v; x != null && !x.equals(source); x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(source);
        java.util.Collections.reverse(path);
        return path;
    }
}
