import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private PriorityQueue<Vertex<V>> priorityQueue;

    public DijkstraSearch(Vertex<V> start) {
        super(start);
        dijkstra(start);
    }

    private void dijkstra(Vertex<V> source) {
        for (Vertex<V> vertex : source.getAdjacentVertices().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    priorityQueue.remove(neighbor);
                    priorityQueue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return distTo.containsKey(vertex);
    }

    @Override
    public List<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) return null;
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> at = vertex; at != null; at = edgeTo.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    public double distanceTo(Vertex<V> vertex) {
        return distTo.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
}
