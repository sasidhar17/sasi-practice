package graph;

import java.util.*;

public class ShortestPath {
    public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        HashMap<String, List<String>> graph = buildGraph(edges);
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<AbstractMap.SimpleEntry<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new AbstractMap.SimpleEntry<>(nodeA, 0));
        visited.add(nodeA);
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> entry = queue.remove();
            String node = entry.getKey();
            int distance = entry.getValue();

            if (node == nodeB) {
                return distance;
            }

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor, distance + 1));
                    visited.add(neighbor);
                }
            }
        }

        return -1;
    }

    public static HashMap<String, List<String>> buildGraph(List<List<String>> edges) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            String a = edge.get(0);
            String b = edge.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(shortestPath(List.of(
                List.of("a", "c"),
                List.of("a", "b"),
                List.of("c", "b"),
                List.of("c", "d"),
                List.of("b", "d"),
                List.of("e", "d"),
                List.of("g", "f")
        ), "a", "e"));
    }
}
