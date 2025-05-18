public class Main {
    public static void main(String[] args) {
        Vertex<String> aidos = new Vertex<>("Aidos");
        Vertex<String> bolat = new Vertex<>("Bolat");
        Vertex<String> dana = new Vertex<>("Dana");
        Vertex<String> erlan = new Vertex<>("Erlan");
        Vertex<String> farida = new Vertex<>("Farida");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(aidos, bolat, 3);
        graph.addEdge(aidos, dana, 2);
        graph.addEdge(bolat, erlan, 4);
        graph.addEdge(dana, erlan, 1);
        graph.addEdge(erlan, farida, 5);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(aidos);
        System.out.println("BFS Path Aidos to Farida: " + bfs.pathTo(farida));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(aidos);
        System.out.println("Dijkstra Path Aidos to Farida: " + dijkstra.pathTo(farida));
        System.out.println("Distance: " + dijkstra.distanceTo(farida));
    }
}
