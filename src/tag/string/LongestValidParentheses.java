package tag.string;

import java.util.Stack;

class LongestValidParentheses {
    // https://leetcode.com/problems/longest-valid-parentheses/description/
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses c = new LongestValidParentheses();
        int len = c.longestValidParentheses(")()())");
        System.out.println(len);
    }
}