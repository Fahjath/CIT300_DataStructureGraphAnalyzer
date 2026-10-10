package graph;

public class CampusGraphTest {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

        // Add vertices
        graph.addVertex("Library");
        graph.addVertex("Cafeteria");
        graph.addVertex("Lecture Hall");
        graph.addVertex("Laboratory");
        graph.addVertex("Main Gate");

        // Add edges
        graph.addEdge("Library", "Cafeteria");
        graph.addEdge("Library", "Lecture Hall");
        graph.addEdge("Cafeteria", "Laboratory");
        graph.addEdge("Lecture Hall", "Main Gate");

        System.out.println("===== GRAPH =====");
        graph.displayGraph();

        System.out.println();

        System.out.println("===== SEARCH =====");

        System.out.println(
            "Library exists: "
            + graph.searchVertex("Library")
        );

        System.out.println(
            "Hostel exists: "
            + graph.searchVertex("Hostel")
        );

        System.out.println();

        System.out.println("===== BFS =====");
        graph.bfs("Library");

        System.out.println();

        System.out.println("===== DFS =====");
        graph.dfs("Library");
    }
}
