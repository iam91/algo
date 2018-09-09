package tag.string;

import java.util.Stack;

public class LongestValidParentheses {
    // https://leetcode.com/problems/longest-valid-parentheses/description/
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int max = 0;
        while(idx < n) {
            int len = 0, i;
            for(i = idx; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == '(') {
                    stack.push(i);
                }
                if(ch == ')') {
                    if(stack.isEmpty()) {
                        // too many right parentheses
                        max = Math.max(max, len);
                        idx = i + 1;
                        break;
                    } else {
                        stack.pop();
                        len += 2;
                    }
                }
            }

            if(!stack.isEmpty()) {
                if(i == n) {
                    break;
                }
                // too many left parentheses
                if(stack.size() == 1) idx = stack.pop() + 1;
                else {
                    while(stack.size() > 2) stack.pop();
                    idx = stack.pop();
                    max = Math.max(max, len);
                }
                stack.clear();
            } else if(i == n) {
                max = Math.max(max, len);
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses c = new LongestValidParentheses();
        String s = "()(()";
        System.out.println(s.length());
        System.out.println(c.longestValidParentheses(s));
    }
}
