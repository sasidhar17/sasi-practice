package graph;

import java.util.*;

public class FindPathRecursive {
    private static final Map<Character, List<Character>> GRAPH = initializeGraph();

    private static Map<Character, List<Character>> initializeGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('c', 'b'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());
        return graph;
    }

    public boolean findPathRecursive(Map<Character, List<Character>> graph, Character source, Character des) {
        if (source == des) {
            return true;
        }
        for (char c : graph.get(source)) {
            if (findPathRecursive(graph, c, des)) {
                return true;
            }
        }

        return false;
    }

    public boolean findPathIterative(Map<Character, List<Character>> graph, Character source, Character des) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            char current = queue.remove();
            if (current == des) {
                return true;
            } else {
                queue.addAll(graph.get(current));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new graph.FindPathRecursive().findPathRecursive(GRAPH, 'a', 'd'));
        System.out.println(new graph.FindPathRecursive().findPathIterative(GRAPH, 'a', 'd'));
    }
}
