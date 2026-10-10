package graph;

import java.util.*;

public class CampusGraph {

    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add Vertex
    public boolean addVertex(String vertex) {

        if (vertex == null || vertex.trim().isEmpty()) {
            return false;
        }

        if (adjacencyList.containsKey(vertex)) {
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<>());

        return true;
    }

    // Add Edge
    public boolean addEdge(String vertex1, String vertex2) {

        if (!adjacencyList.containsKey(vertex1)
                || !adjacencyList.containsKey(vertex2)) {
            return false;
        }

        if (vertex1.equals(vertex2)) {
            return false;
        }

        if (adjacencyList.get(vertex1).contains(vertex2)) {
            return false;
        }

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);

        return true;
    }

    // Display Graph
    public void displayGraph() {

        for (String vertex : adjacencyList.keySet()) {

            System.out.println(
                vertex + " -> " + adjacencyList.get(vertex)
            );
        }
    }

    // Search Vertex
    public boolean searchVertex(String vertex) {

        return adjacencyList.containsKey(vertex);
    }

    // BFS Traversal
    public void bfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    public void dfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.print("DFS: ");

        dfsRecursive(startVertex, visited);

        System.out.println();
    }

    private void dfsRecursive(
            String vertex,
            Set<String> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (String neighbour : adjacencyList.get(vertex)) {

            if (!visited.contains(neighbour)) {

                dfsRecursive(neighbour, visited);
            }
        }
    }
}