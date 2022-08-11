public class Graph<T extends GraphNode> {

    public interface GraphNode {
        String getId();
    }

    public class Graph<T extends GraphNode> {
        private final Set<T> nodes;
        private final Map<String, Set<String>> connections;
        
        public T getNode(String id) {
            return nodes.stream()
                .filter(node -> node.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No node found with ID"));
        }

        public Set<T> getConnections(T node) {
            return connections.get(node.getId()).stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
        }
    }

    public interface Scorer<T extends GraphNode> {
        double computeCost(T from, T to);
    }

    class RouteNode<T extends GraphNode> implements Comparable<RouteNode> {
        private final T current;
        private T previous;
        private double routeScore;
        private double estimatedScore;
    
        RouteNode(T current) {
            this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
    
        RouteNode(T current, T previous, double routeScore, double estimatedScore) {
            this.current = current;
            this.previous = previous;
            this.routeScore = routeScore;
            this.estimatedScore = estimatedScore;
        }
    }
}

