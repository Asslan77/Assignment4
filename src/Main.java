public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(c, d, 1);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(a);
        System.out.println("BFS Path A to D: " + bfs.pathTo(d));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(a);
        System.out.println("Dijkstra Path A to D: " + dijkstra.pathTo(d));
        System.out.println("Distance: " + dijkstra.distanceTo(d));
    }
}
