package agoda;

import java.util.Map;
import java.util.Stack;

public class ChemicalWeights {

    private static final Map<String, Integer> WEIGHTS = Map.of("C", 12, "H", 1, "O", 2);

    public static int calculateWeight(String formula) {
        Stack<Integer> totals = new Stack<>();
        totals.push(0); // total outside all parentheses

        int i = 0;

        while (i < formula.length()) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                // Start tracking a new group, such as (OH)
                totals.push(0);
                i++;

            } else if (ch == ')') {
                // Finish a group and apply its multiplier
                i++;

                int start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                int multiplier = start == i ? 1 : Integer.parseInt(formula.substring(start, i));

                int groupWeight = totals.pop();
                int outerWeight = totals.pop();

                totals.push(outerWeight + groupWeight * multiplier);

            } else {
                // Read an element name: C, H, O, Na, etc.
                int start = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String element = formula.substring(start, i);

                // Read its optional count: H2 -> 2, C -> 1
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));

                int weight = WEIGHTS.getOrDefault(element, 0);

                totals.push(totals.pop() + weight * count);
            }
        }

        return totals.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculateWeight("C(OH)4")); // 24
    }
}