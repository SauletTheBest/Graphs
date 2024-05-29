---
# Graph Search Algorithms in Java

-**Insturctor: Khaimuldin Nursultan**
**Student: Saulet Kabdrakhmanov**

## Overview

This assignment involves implementing Breadth-First Search (BFS), Depth-First Search (DFS), and Dijkstra's Algorithm for an edge-weighted graph using a vertex-centric approach. The graph will be modeled using custom `Vertex` and `Edge` classes, and the main graph operations will be handled by the `MyGraph` class. The goal is to create a flexible and reusable graph structure that allows easy addition of vertices and edges, and provides efficient pathfinding capabilities.

## Classes

### Vertex<V>

This class represents a vertex in the graph.

- **Fields:**
  - `data`: The value/data stored in the vertex.
  - `adjacentEdges`: A list of edges originating from this vertex.

- **Methods:**
  - `Vertex(V data)`: Constructor to initialize the vertex with data.
  - `getData()`: Returns the data stored in the vertex.
  - `addAdjacentVertex(Vertex<V> destination, double weight)`: Adds an adjacent vertex with the specified weight.
  - `getAdjacentEdges()`: Returns the list of adjacent edges.
  - `toString()`: Returns a string representation of the vertex.
  - `equals(Object o)`: Checks if two vertices are equal based on their data.
  - `hashCode()`: Returns the hash code for the vertex based on its data.

### Edge<V>

This class represents an edge in the graph.

- **Fields:**
  - `source`: The source vertex of the edge.
  - `dest`: The destination vertex of the edge.
  - `weight`: The weight of the edge.

- **Methods:**
  - `Edge(V source, V dest, Double weight)`: Constructor to initialize the edge with source, destination, and weight.
  - `Edge(V source, V dest)`: Constructor to initialize the edge with source and destination.
  - `setSource(V source)`: Sets the source vertex.
  - `getSource()`: Returns the source vertex.
  - `setDest(V dest)`: Sets the destination vertex.
  - `getDest()`: Returns the destination vertex.
  - `setWeight(Double weight)`: Sets the weight of the edge.
  - `getWeight()`: Returns the weight of the edge.
  - `equals(Object o)`: Checks if two edges are equal based on their source and destination.
  - `hashCode()`: Returns the hash code for the edge based on its source and destination.

### MyGraph<V>

This class represents a graph structure.

- **Fields:**
  - `vertices`: A map of vertex data to vertex objects.

- **Methods:**
  - `MyGraph()`: Constructor to initialize the graph.
  - `addVertex(V value)`: Adds a vertex to the graph.
  - `addEdge(V source, V dest, double weight)`: Adds an edge between two vertices with the specified weight.
  - `getVertex(V value)`: Returns the vertex object for the specified data.
  - `getVertices()`: Returns a map of all vertices in the graph.

### Search<V>

An abstract class representing a generic search algorithm.

- **Fields:**
  - `marked`: A map to keep track of visited vertices.
  - `edgeTo`: A map to keep track of the path.
  - `source`: The source vertex from which the search begins.

- **Methods:**
  - `Search(Vertex<V> source)`: Constructor to initialize the search with the source vertex.
  - `search(Vertex<V> source)`: An abstract method to perform the search.
  - `hasPathTo(Vertex<V> v)`: Checks if there is a path to the specified vertex.
  - `pathTo(Vertex<V> v)`: Returns the path to the specified vertex.

### BreadthFirstSearch<V>

A class that extends `Search` to implement BFS.

- **Methods:**
  - `BreadthFirstSearch(Vertex<V> source)`: Constructor to initialize the BFS with the source vertex.
  - `search(Vertex<V> source)`: Performs the BFS starting from the source vertex.

### DepthFirstSearch<V>

A class that extends `Search` to implement DFS.

- **Methods:**
  - `DepthFirstSearch(Vertex<V> source)`: Constructor to initialize the DFS with the source vertex.
  - `search(Vertex<V> source)`: Performs the DFS starting from the source vertex.

### DijkstraSearch<V>

A class that extends `Search` to implement Dijkstra's Algorithm.

- **Fields:**
  - `distTo`: A map to keep track of the shortest distance to each vertex.

- **Methods:**
  - `DijkstraSearch(Vertex<V> source)`: Constructor to initialize Dijkstra's Algorithm with the source vertex.
  - `initializeDistances(Vertex<V> source)`: Initializes distances to all vertices as infinity.
  - `getAllVertices(Vertex<V> source)`: Returns all vertices reachable from the source.
  - `visitAllVertices(Vertex<V> vertex, Map<Vertex<V>, Boolean> visited)`: Helper method to visit all vertices.
  - `search(Vertex<V> source)`: Performs Dijkstra's Algorithm starting from the source vertex.

## Main Class Example Usage

The `Main` class demonstrates how to use the graph and search classes:

```java
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
        graph.addEdge("Nagoya", "Osaka", 

5);
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
        
        System.out.println("\nDFS:");
        DepthFirstSearch<String> dfs = new DepthFirstSearch<>(source);
        System.out.println("Path from Tokyo to Kyoto: " + dfs.pathTo(targetKyoto));
        System.out.println("Path from Tokyo to Osaka: " + dfs.pathTo(targetOsaka));
        System.out.println("Path from Tokyo to Hiroshima: " + dfs.pathTo(targetHiroshima));
    }
}
```

### Expected Output

The paths and vertices will be printed based on the BFS, DFS, and Dijkstra's Algorithm implementations. For example:

```
BFS:
Path from Tokyo to Kyoto: [Tokyo, Nagoya, Kyoto]
Path from Tokyo to Osaka: [Tokyo, Nagoya, Osaka]
Path from Tokyo to Hiroshima: [Tokyo, Nagoya, Kyoto, Osaka, Hiroshima]

Vertices in the graph:
{Tokyo=Tokyo, Kyoto=Kyoto, Osaka=Osaka, Kobe=Kobe, Nagoya=Nagoya, Hiroshima=Hiroshima}

Dijkstra:
Path from Tokyo to Kyoto: [Tokyo, Nagoya, Kyoto]
Path from Tokyo to Osaka: [Tokyo, Nagoya, Kyoto, Osaka]
Path from Tokyo to Hiroshima: [Tokyo, Nagoya, Kyoto, Osaka, Hiroshima]

DFS:
Path from Tokyo to Kyoto: [Tokyo, Nagoya, Kyoto]
Path from Tokyo to Osaka: [Tokyo, Nagoya, Kyoto, Osaka]
Path from Tokyo to Hiroshima: [Tokyo, Nagoya, Kyoto, Osaka, Hiroshima]
```

## Conclusion

This assignment demonstrates how to implement and use graph data structures and search algorithms in Java. The BFS, DFS, and Dijkstra's Algorithm provide different methods for finding paths in the graph, showcasing the flexibility and power of graph-based algorithms.
