package graph;

import java.util.*;

public class DepthFirstSearch {

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

    public void depthFirstSearch(Map<Character, List<Character>> graph, Character source) {
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            char current = stack.pop();
            System.out.print(current + " ");
            for (char c : graph.get(current)) {
                stack.push(c);
            }
        }
    }

    public static void main(String[] args) {
        new DepthFirstSearch().depthFirstSearch(GRAPH, 'a');
    }
}
