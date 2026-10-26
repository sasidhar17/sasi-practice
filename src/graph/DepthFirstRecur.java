package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstRecur {
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

    public void depthFirstSearchRecur(Map<Character, List<Character>> graph, Character source) {
        System.out.print(source + " ");
        for (char c : graph.get(source)) {
            depthFirstSearchRecur(graph, c);
        }
    }

    public static void main(String[] args) {
        new DepthFirstRecur().depthFirstSearchRecur(GRAPH, 'a');
    }
}
