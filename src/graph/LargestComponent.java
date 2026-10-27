package graph;

import java.util.*;

public class LargestComponent {

    public static int largestComponent(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int maxSize = 0;
        for (int node : graph.keySet()) {
            maxSize = Math.max(maxSize, traverseSize(graph, node, visited));
        }
        return maxSize;
    }

    public static int traverseSize(Map<Integer, List<Integer>> graph, int node, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);

        int count = 1;
        for (int neighbor : graph.get(node)) {
            count += traverseSize(graph, neighbor, visited);
        }
        return count;
    }

    public static int largestComponentIterative(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int maxSize = 0;
        for (int node : graph.keySet()) {
            maxSize = Math.max(maxSize, traverseSize(graph, node, visited));
        }
        return maxSize;
    }

    public static int traverseSizeIterative(Map<Integer, List<Integer>> graph, int src, HashSet<Integer> visited) {
        if (visited.contains(src)) {
            return 0;
        }
        visited.add(src);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        int size = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            size += 1;
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        System.out.println(largestComponentIterative(Map.of(
                3, List.of(),
                4, List.of(6),
                6, List.of(4, 5, 7, 8),
                8, List.of(6),
                7, List.of(6),
                5, List.of(6),
                1, List.of(2),
                2, List.of(1)
        )));
        System.out.println(largestComponent(Map.of(
                3, List.of(),
                4, List.of(6),
                6, List.of(4, 5, 7, 8),
                8, List.of(6),
                7, List.of(6),
                5, List.of(6),
                1, List.of(2),
                2, List.of(1)
        )));
    }
}
