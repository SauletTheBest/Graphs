public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();
        graph.addVertex("Tokyo");
        graph.addVertex("Kyoto");
        graph.addVertex("Osaka");
        graph.addVertex("Kobe");
        graph.addVertex("Nagoya");
        graph.addVertex("Hiroshima");

        graph.addEdge("Tokyo", "Nagoya", 4);
        graph.addEdge("Tokyo", "Osaka", 8);
        graph.addEdge("Nagoya", "Kyoto", 2);
        graph.addEdge("Nagoya", "Osaka", 5);
        graph.addEdge("Kyoto", "Osaka", 1);
        graph.addEdge("Kyoto", "Kobe", 3);
        graph.addEdge("Osaka", "Kobe", 2);
        graph.addEdge("Osaka", "Hiroshima", 6);
        graph.addEdge("Kobe", "Hiroshima", 4);

        Vertex<String> source = graph.getVertex("Tokyo");
        Vertex<String> targetKyoto = graph.getVertex("Kyoto");
        Vertex<String> targetOsaka = graph.getVertex("Osaka");
        Vertex<String> targetKobe = graph.getVertex("Kobe");
        Vertex<String> targetHiroshima = graph.getVertex("Hiroshima");

        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(source);
        System.out.println("Path from Tokyo to Kyoto: " + bfs.pathTo(targetKyoto));
        System.out.println("Path from Tokyo to Osaka: " + bfs.pathTo(targetOsaka));
        System.out.println("Path from Tokyo to Hiroshima: " + bfs.pathTo(targetHiroshima));

        System.out.println("\nVertices in the graph:");
        System.out.println(graph.getVertices());

        System.out.println("\nDijkstra:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(source);
        System.out.println("Path from Tokyo to Kyoto: " + dijkstra.pathTo(targetKyoto));
        System.out.println("Path from Tokyo to Osaka: " + dijkstra.pathTo(targetOsaka));
        System.out.println("Path from Tokyo to Hiroshima: " + dijkstra.pathTo(targetHiroshima));

    }
}
