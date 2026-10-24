package stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String input) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        if (input == null || input.isEmpty()) {
            return maxLength;
        }
        stack.push(-1);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }

}
