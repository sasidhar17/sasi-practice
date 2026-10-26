package graph;

import java.util.*;

public class BreathFirstSearch {

    private static final Map<Character, List<Character>> GRAPH = initializeGraph();

    private static Map<Character, List<Character>> initializeGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('b', 'c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());
        return graph;
    }

    public void breathFirstSearch(Map<Character, List<Character>> graph, Character source) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            char current = queue.remove();
            System.out.print(current + " ");
            queue.addAll(graph.get(current));
        }
    }

    public static void main(String[] args) {
        new BreathFirstSearch().breathFirstSearch(GRAPH, 'a');
    }
}
